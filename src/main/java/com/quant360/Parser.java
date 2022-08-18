package com.quant360;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser <T, S extends Iterable<S>> {

    @SuppressWarnings("unchecked")
    public List<HashMap<String, String>> parse(T decoder, S noMDEntriesDecoder, HashMap<String, String> initialMap) {
        Class<T> clazz = (Class<T>) decoder.getClass();
        List<HashMap<String, String>> values = new ArrayList<>();
        try {
            HashMap<String, String> messageFieldsValues = new HashMap<>(initialMap);
            for (Method method : clazz.getMethods()) {
                if (method.getName().endsWith("MetaAttribute")) {
                    Method m = clazz.getMethod(method.getName().replace("MetaAttribute", ""));
                    messageFieldsValues.put(m.getName(), m.invoke(decoder).toString());
                }
            }

            messageFieldsValues.put("noMDEntries", noMDEntriesDecoder.getClass().getMethod("count").invoke(noMDEntriesDecoder).toString());

            for (S noMDEntry : noMDEntriesDecoder) {
                HashMap<String, String> row = new HashMap<>(messageFieldsValues);
                for (Method method : noMDEntry.getClass().getMethods()) {
                    if (method.getName().endsWith("MetaAttribute")) {
                        Method m = noMDEntry.getClass().getMethod(method.getName().replace("MetaAttribute", ""));
                        row.put(m.getName(), m.invoke(noMDEntry).toString());
                    }
                }
                values.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }
}
