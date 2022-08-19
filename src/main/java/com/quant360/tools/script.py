import sys
import xml.etree.ElementTree as ET

schema_file = sys.argv[1] if len(sys.argv) > 1 else '/home/ytliu/Source/CMEParser/src/main/resources/schema.xml'
ns2 = '{http://www.fixprotocol.org/ns/simple/1.0}'


def lower_first(s: str):
    return s[0].lower() + s[1:]


def main():
    root = ET.parse(schema_file).getroot()
    types = root.find('types').findall('type')
    messages = root.findall(ns2 + 'message')
    
    for message in messages:
        append_to = """    
    public toListOfHashMap(
        MessageHeaderDecoder headerDecoder,
        HashMap<String, String> packetInfo
    ) {
        List<HashMap<String, String>> rows = new ArrayList<>();
        HashMap<String, String> messageFields = new HashMap<>(packetInfo);

        messageFields.put("sbeTemplateId", String.valueOf(headerDecoder.templateId()));
        messageFields.put("sbeSchemaId", String.valueOf(headerDecoder.schemaId()));
        messageFields.put("sbeSchemaVersion", String.valueOf(headerDecoder.version()));
        messageFields.put("sbeBlockLength", String.valueOf(headerDecoder.blockLength()));
        // limit(initialOffset + actingBlockLength);
"""
        fields = message.findall(fields)
        groups = message.findall(groups)
        for field in fields:
            append_to += f"        messageFields.put(\"{field.get('name')}\"), String.valueOf({lower_first(field.get('name'))}())"
            pass

        append_to += """
        limit(originalLimit);

        return builder;
    }"""


if __name__ == '__main__':
    print(lower_first("LastDay"))