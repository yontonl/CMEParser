package com.quant360.sbe.codec;

import java.util.List;
import java.util.HashMap;

public interface Decoder {
    List<HashMap<String, String>> toListOfHashmaps(MessageHeaderDecoder headerDecoder, HashMap<String, String> packetInfo);
}
