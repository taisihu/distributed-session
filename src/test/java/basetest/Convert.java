package basetest;


import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @(#)Convert.java
 *
 *
 *
 * @author hcmfys@163.com
 * @version 1.00 2013/5/22
 */

public class Convert {

    private int hex2oct(char p) throws UnsupportedEncodingException {
        char hexData[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        for (int i = 0; i < hexData.length; i++) {
            if (Character.toUpperCase(hexData[i]) == p) {
                return i;
            }
        }
        throw new UnsupportedEncodingException("Unsupported Hex Encoding");

    }
    /***
     *
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @param charset
     * @return
     * @throws UnsupportedEncodingException
     */
    private String hexString2String(char p1, char p2, char p3, char p4, String charset)
            throws UnsupportedEncodingException {

        byte first = (byte) (hex2oct(p1) * 16 + hex2oct(p2));
        byte second = (byte) (hex2oct(p3) * 16 + hex2oct(p4));
        byte[] bytes = new byte[2];
        bytes[0] = first;
        bytes[1] = second;

        return new String(bytes, charset);

    }

    /**
     * &#x7EC4;&#x7EC7;&#x4E13;&#x7EBF;&#x5F00;&#x901A;
     *
     * @throws UnsupportedEncodingException
     */
    public	String doDecoder(String html, String charset)
            throws UnsupportedEncodingException {
        int size = html.length();
        String result = "";
        for (int i = 0; i < size; i++) {
            char c = html.charAt(i);
            if (c == '&') {
                if ((i + 7) < size) {
                    if (html.charAt(i + 1) == '#' && Character.toUpperCase(html.charAt(i + 2)) == 'X') {
                        char p1 = html.charAt(i + 3);
                        char p2 = html.charAt(i + 4);
                        char p3 = html.charAt(i + 5);
                        char p4 = html.charAt(i + 6);
                        String s = hexString2String(p1, p2, p3, p4, charset);
                        result += s;
                        i += 7;
                    }
                } else {
                    result += c;
                    continue;
                }
            } else {
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

//        Convert c = new Convert();
//        String s = c.doDecoder(
//                "&#xE93F;", "utf16");
//
//        System.out.println(s);



//        // 定义正则表达式来搜索中文字符的转义符号
//        Pattern compile = Pattern.compile("&#.*?;");
//        // 测试用中文字符
//        String sourceString = "&#xe93f;";
//        Matcher matcher = compile.matcher(sourceString);
//        // 循环搜索 并转换 替换
//        while (matcher.find()) {
//            String group = matcher.group();
//            // 获得16进制的码
//            String hexcode = "0" + group.replaceAll("(&#|;)", "");
//            // 字符串形式的16进制码转成int并转成char 并替换到源串中
//            sourceString = sourceString.replaceAll(group, (char) Integer.decode(hexcode).intValue() + "");
//        }
//        System.out.println(sourceString);

//        String s = StringEscapeUtils.escapeJava("男");
//        System.out.println(s);


    }
}

