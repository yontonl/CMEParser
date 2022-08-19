/* Generated SBE (Simple Binary Encoding) message codec. */
package com.quant360.sbe.codec;

import org.agrona.DirectBuffer;
import org.agrona.sbe.*;

@uk.co.real_logic.sbe.codec.java.GroupOrder({
    QuoteRequest39Decoder.NoRelatedSymDecoder.class})
/**
 * QuoteRequest
 */
@SuppressWarnings("all")
public final class QuoteRequest39Decoder implements MessageDecoderFlyweight
{
    public static final int BLOCK_LENGTH = 35;
    public static final int TEMPLATE_ID = 39;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 9;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final QuoteRequest39Decoder parentMessage = this;
    private DirectBuffer buffer;
    private int initialOffset;
    private int offset;
    private int limit;
    int actingBlockLength;
    int actingVersion;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "R";
    }

    public DirectBuffer buffer()
    {
        return buffer;
    }

    public int initialOffset()
    {
        return initialOffset;
    }

    public int offset()
    {
        return offset;
    }

    public QuoteRequest39Decoder wrap(
        final DirectBuffer buffer,
        final int offset,
        final int actingBlockLength,
        final int actingVersion)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.initialOffset = offset;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

        return this;
    }

    public QuoteRequest39Decoder wrapAndApplyHeader(
        final DirectBuffer buffer,
        final int offset,
        final MessageHeaderDecoder headerDecoder)
    {
        headerDecoder.wrap(buffer, offset);

        final int templateId = headerDecoder.templateId();
        if (TEMPLATE_ID != templateId)
        {
            throw new IllegalStateException("Invalid TEMPLATE_ID: " + templateId);
        }

        return wrap(
            buffer,
            offset + MessageHeaderDecoder.ENCODED_LENGTH,
            headerDecoder.blockLength(),
            headerDecoder.version());
    }

    public QuoteRequest39Decoder sbeRewind()
    {
        return wrap(buffer, initialOffset, actingBlockLength, actingVersion);
    }

    public int sbeDecodedLength()
    {
        final int currentLimit = limit();
        sbeSkip();
        final int decodedLength = encodedLength();
        limit(currentLimit);

        return decodedLength;
    }

    public int encodedLength()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        this.limit = limit;
    }

    public static int transactTimeId()
    {
        return 60;
    }

    public static int transactTimeSinceVersion()
    {
        return 0;
    }

    public static int transactTimeEncodingOffset()
    {
        return 0;
    }

    public static int transactTimeEncodingLength()
    {
        return 8;
    }

    public static String transactTimeMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "UTCTimestamp";
        }

        return "";
    }

    public static long transactTimeNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long transactTimeMinValue()
    {
        return 0x0L;
    }

    public static long transactTimeMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public long transactTime()
    {
        return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int quoteReqIDId()
    {
        return 131;
    }

    public static int quoteReqIDSinceVersion()
    {
        return 0;
    }

    public static int quoteReqIDEncodingOffset()
    {
        return 8;
    }

    public static int quoteReqIDEncodingLength()
    {
        return 23;
    }

    public static String quoteReqIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "String";
        }

        return "";
    }

    public static byte quoteReqIDNullValue()
    {
        return (byte)0;
    }

    public static byte quoteReqIDMinValue()
    {
        return (byte)32;
    }

    public static byte quoteReqIDMaxValue()
    {
        return (byte)126;
    }

    public static int quoteReqIDLength()
    {
        return 23;
    }


    public byte quoteReqID(final int index)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = offset + 8 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String quoteReqIDCharacterEncoding()
    {
        return java.nio.charset.StandardCharsets.US_ASCII.name();
    }

    public int getQuoteReqID(final byte[] dst, final int dstOffset)
    {
        final int length = 23;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(offset + 8, dst, dstOffset, length);

        return length;
    }

    public String quoteReqID()
    {
        final byte[] dst = new byte[23];
        buffer.getBytes(offset + 8, dst, 0, 23);

        int end = 0;
        for (; end < 23 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getQuoteReqID(final Appendable value)
    {
        for (int i = 0; i < 23; ++i)
        {
            final int c = buffer.getByte(offset + 8 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 23;
    }


    public static int matchEventIndicatorId()
    {
        return 5799;
    }

    public static int matchEventIndicatorSinceVersion()
    {
        return 0;
    }

    public static int matchEventIndicatorEncodingOffset()
    {
        return 31;
    }

    public static int matchEventIndicatorEncodingLength()
    {
        return 1;
    }

    public static String matchEventIndicatorMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }
        if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
        {
            return "MultipleCharValue";
        }

        return "";
    }

    private final MatchEventIndicatorDecoder matchEventIndicator = new MatchEventIndicatorDecoder();

    /**
     * Bitmap field of eight Boolean type indicators reflecting the end of updates for a given Globex event
     *
     * @return MatchEventIndicatorDecoder : Bitmap field of eight Boolean type indicators reflecting the end of updates for a given Globex event
     */
    public MatchEventIndicatorDecoder matchEventIndicator()
    {
        matchEventIndicator.wrap(buffer, offset + 31);
        return matchEventIndicator;
    }

    private final NoRelatedSymDecoder noRelatedSym = new NoRelatedSymDecoder(this);

    public static long noRelatedSymDecoderId()
    {
        return 146;
    }

    public static int noRelatedSymDecoderSinceVersion()
    {
        return 0;
    }

    /**
     * Indicates the number of repeating symbols specified
     *
     * @return NoRelatedSymDecoder : Indicates the number of repeating symbols specified
     */
    public NoRelatedSymDecoder noRelatedSym()
    {
        noRelatedSym.wrap(buffer);
        return noRelatedSym;
    }

    /**
     * Indicates the number of repeating symbols specified
     */

    public static final class NoRelatedSymDecoder
        implements Iterable<NoRelatedSymDecoder>, java.util.Iterator<NoRelatedSymDecoder>
    {
        public static final int HEADER_SIZE = 3;
        private final QuoteRequest39Decoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        NoRelatedSymDecoder(final QuoteRequest39Decoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final DirectBuffer buffer)
        {
            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }

            index = 0;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + HEADER_SIZE);
            blockLength = (buffer.getShort(limit + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
            count = ((short)(buffer.getByte(limit + 2) & 0xFF));
        }

        public NoRelatedSymDecoder next()
        {
            if (index >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + blockLength);
            ++index;

            return this;
        }

        public static short countMinValue()
        {
            return (short)0;
        }

        public static short countMaxValue()
        {
            return (short)254;
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 32;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<NoRelatedSymDecoder> iterator()
        {
            return this;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return index < count;
        }

        public static int symbolId()
        {
            return 55;
        }

        public static int symbolSinceVersion()
        {
            return 0;
        }

        public static int symbolEncodingOffset()
        {
            return 0;
        }

        public static int symbolEncodingLength()
        {
            return 20;
        }

        public static String symbolMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "String";
            }

            return "";
        }

        public static byte symbolNullValue()
        {
            return (byte)0;
        }

        public static byte symbolMinValue()
        {
            return (byte)32;
        }

        public static byte symbolMaxValue()
        {
            return (byte)126;
        }

        public static int symbolLength()
        {
            return 20;
        }


        public byte symbol(final int index)
        {
            if (index < 0 || index >= 20)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            final int pos = offset + 0 + (index * 1);

            return buffer.getByte(pos);
        }


        public static String symbolCharacterEncoding()
        {
            return java.nio.charset.StandardCharsets.US_ASCII.name();
        }

        public int getSymbol(final byte[] dst, final int dstOffset)
        {
            final int length = 20;
            if (dstOffset < 0 || dstOffset > (dst.length - length))
            {
                throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
            }

            buffer.getBytes(offset + 0, dst, dstOffset, length);

            return length;
        }

        public String symbol()
        {
            final byte[] dst = new byte[20];
            buffer.getBytes(offset + 0, dst, 0, 20);

            int end = 0;
            for (; end < 20 && dst[end] != 0; ++end);

            return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
        }


        public int getSymbol(final Appendable value)
        {
            for (int i = 0; i < 20; ++i)
            {
                final int c = buffer.getByte(offset + 0 + i) & 0xFF;
                if (c == 0)
                {
                    return i;
                }

                try
                {
                    value.append(c > 127 ? '?' : (char)c);
                }
                catch (final java.io.IOException ex)
                {
                    throw new java.io.UncheckedIOException(ex);
                }
            }

            return 20;
        }


        public static int securityIDId()
        {
            return 48;
        }

        public static int securityIDSinceVersion()
        {
            return 0;
        }

        public static int securityIDEncodingOffset()
        {
            return 20;
        }

        public static int securityIDEncodingLength()
        {
            return 4;
        }

        public static String securityIDMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "int";
            }

            return "";
        }

        public static int securityIDNullValue()
        {
            return -2147483648;
        }

        public static int securityIDMinValue()
        {
            return -2147483647;
        }

        public static int securityIDMaxValue()
        {
            return 2147483647;
        }

        public int securityID()
        {
            return buffer.getInt(offset + 20, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int orderQtyId()
        {
            return 38;
        }

        public static int orderQtySinceVersion()
        {
            return 0;
        }

        public static int orderQtyEncodingOffset()
        {
            return 24;
        }

        public static int orderQtyEncodingLength()
        {
            return 4;
        }

        public static String orderQtyMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "Qty";
            }

            return "";
        }

        public static int orderQtyNullValue()
        {
            return 2147483647;
        }

        public static int orderQtyMinValue()
        {
            return -2147483647;
        }

        public static int orderQtyMaxValue()
        {
            return 2147483647;
        }

        public int orderQty()
        {
            return buffer.getInt(offset + 24, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int quoteTypeId()
        {
            return 537;
        }

        public static int quoteTypeSinceVersion()
        {
            return 0;
        }

        public static int quoteTypeEncodingOffset()
        {
            return 28;
        }

        public static int quoteTypeEncodingLength()
        {
            return 1;
        }

        public static String quoteTypeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "int";
            }

            return "";
        }

        public static byte quoteTypeNullValue()
        {
            return (byte)-128;
        }

        public static byte quoteTypeMinValue()
        {
            return (byte)-127;
        }

        public static byte quoteTypeMaxValue()
        {
            return (byte)127;
        }

        public byte quoteType()
        {
            return buffer.getByte(offset + 28);
        }


        public static int sideId()
        {
            return 54;
        }

        public static int sideSinceVersion()
        {
            return 0;
        }

        public static int sideEncodingOffset()
        {
            return 29;
        }

        public static int sideEncodingLength()
        {
            return 1;
        }

        public static String sideMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }
            if (MetaAttribute.SEMANTIC_TYPE == metaAttribute)
            {
                return "int";
            }

            return "";
        }

        public static byte sideNullValue()
        {
            return (byte)127;
        }

        public static byte sideMinValue()
        {
            return (byte)-127;
        }

        public static byte sideMaxValue()
        {
            return (byte)127;
        }

        public byte side()
        {
            return buffer.getByte(offset + 29);
        }


        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("symbol=");
            for (int i = 0; i < symbolLength() && symbol(i) > 0; i++)
            {
                builder.append((char)symbol(i));
            }
            builder.append('|');
            builder.append("securityID=");
            builder.append(securityID());
            builder.append('|');
            builder.append("orderQty=");
            builder.append(orderQty());
            builder.append('|');
            builder.append("quoteType=");
            builder.append(quoteType());
            builder.append('|');
            builder.append("side=");
            builder.append(side());
            builder.append(')');

            return builder;
        }
        
        public NoRelatedSymDecoder sbeSkip()
        {

            return this;
        }
    }

    public String toString()
    {
        if (null == buffer)
        {
            return "";
        }

        final QuoteRequest39Decoder decoder = new QuoteRequest39Decoder();
        decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

        return decoder.appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        if (null == buffer)
        {
            return builder;
        }

        final int originalLimit = limit();
        limit(initialOffset + actingBlockLength);
        builder.append("[QuoteRequest39](sbeTemplateId=");
        builder.append(TEMPLATE_ID);
        builder.append("|sbeSchemaId=");
        builder.append(SCHEMA_ID);
        builder.append("|sbeSchemaVersion=");
        if (parentMessage.actingVersion != SCHEMA_VERSION)
        {
            builder.append(parentMessage.actingVersion);
            builder.append('/');
        }
        builder.append(SCHEMA_VERSION);
        builder.append("|sbeBlockLength=");
        if (actingBlockLength != BLOCK_LENGTH)
        {
            builder.append(actingBlockLength);
            builder.append('/');
        }
        builder.append(BLOCK_LENGTH);
        builder.append("):");
        builder.append("transactTime=");
        builder.append(transactTime());
        builder.append('|');
        builder.append("quoteReqID=");
        for (int i = 0; i < quoteReqIDLength() && quoteReqID(i) > 0; i++)
        {
            builder.append((char)quoteReqID(i));
        }
        builder.append('|');
        builder.append("matchEventIndicator=");
        matchEventIndicator().appendTo(builder);
        builder.append('|');
        builder.append("noRelatedSym=[");
        final int noRelatedSymOriginalOffset = noRelatedSym.offset;
        final int noRelatedSymOriginalIndex = noRelatedSym.index;
        final NoRelatedSymDecoder noRelatedSym = noRelatedSym();
        if (noRelatedSym.count() > 0)
        {
            while (noRelatedSym.hasNext())
            {
                noRelatedSym.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        noRelatedSym.offset = noRelatedSymOriginalOffset;
        noRelatedSym.index = noRelatedSymOriginalIndex;
        builder.append(']');

        limit(originalLimit);

        return builder;
    }
    
    public QuoteRequest39Decoder sbeSkip()
    {
        sbeRewind();
        NoRelatedSymDecoder noRelatedSym = noRelatedSym();
        if (noRelatedSym.count() > 0)
        {
            while (noRelatedSym.hasNext())
            {
                noRelatedSym.next();
                noRelatedSym.sbeSkip();
            }
        }

        return this;
    }
}
