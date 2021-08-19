package com.dizhongdi.haffmanCode;

import java.io.*;
import java.util.*;

/**
 * ClassName:TestHuffmanCode
 * Package:com.dizhongdi.haffmanCode
 * Description:
 *
 * @Date: 2021/2/6 21:42
 * @Author:dizhongdi
 */
public class TestHuffmanCode {
    public static void main(String[] args) {
//        String msg = "can you can a can as a can canner can a can.";
//        byte[] bytes = msg.getBytes();
//        //进行赫夫曼编码
//        byte[] b = huffmanZip(bytes);
//        //使用赫夫曼编码表进行解码
//        byte[] newBytes = doCode(huffCodes,b);
//        System.out.println(new String(newBytes));
        String src = "D:\\IdeaProjects\\SuanFa\\src\\dzd2.png";
        String dst = "D:\\IdeaProjects\\SuanFa\\src\\dzd.zip";
//        try {
//            zipFile(src,dst);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            unZip(dst,src);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 解压文件
     * @param src 要解压的文件路径
     * @param dst 解压后存储路径
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void unZip(String src, String dst ) throws IOException, ClassNotFoundException {
        //创建一个输入流
        FileInputStream i = new FileInputStream(src);
        ObjectInputStream oi = new ObjectInputStream(i);
        //读取byte数组
        byte[] b = (byte[]) oi.readObject();
        Map<Byte,String> codes = (Map<Byte, String>) oi.readObject();
        oi.close();
        i.close();
        //解码
        byte[] nb = doCode(codes,b);
        //创建一个输入流
        OutputStream o = new FileOutputStream(dst);
        //写出数据
        o.write(nb);
        o.close();
    }

    //用赫夫曼编码对文件进行压缩

    /**
     * 压缩文件
     * @param src
     * @param dst
     * @throws IOException
     */
    private static void zipFile(String src, String dst) throws IOException {
        //创建一个输入流
        InputStream i = new FileInputStream(src);
        //根据输入流指向文件的长度创建一个相同长度的byte数组
        byte[] b = new byte[i.available()];
        //读取文件内容
        i.read(b);
        i.close();
        //用赫夫曼编码进行编码
        byte[] nb = huffmanZip(b);
        //输出流
        OutputStream o = new FileOutputStream(dst);
        ObjectOutputStream oos = new ObjectOutputStream(o);
        //把压缩后的byte数组写入文件
        oos.writeObject(nb);
        //把赫夫曼编码表写入文件
        oos.writeObject(huffCodes);
        oos.close();
        o.close();
    }

    /**
     * 使用指定的赫夫曼码表进行解码
     * @param huffCodes
     * @param bytes
     * @return
     */
    private static byte[] doCode(Map<Byte, String> huffCodes, byte[] bytes) {
        //把byte数组转为一个二进制的字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< bytes.length;i++){
            byte b = bytes[i];
            //是否是最后一个
            boolean flag = !(i==bytes.length-1);
            String s = Integer.toBinaryString(b);
            sb.append(byteTobitStr(b,flag));
        }
        //把字符串按照指定的赫夫曼编码进行解码
        //把赫夫曼编码的键值对进行调换
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String> entry : huffCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        //创建一个for循环用于存byte
        List<Byte> list = new ArrayList<>();
        //处理字符串
        for (int i = 0; i<sb.length();){
            int count = 1;
            boolean flag = true;
            //截出一个key
            Byte b = null;
            while (flag){
                String key = sb.substring(i, i + count);
                b = map.get(key);
                if (b==null){
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i+=count;
        }
        //把集合转为数组
        byte[] b = new byte[list.size()];
        for (int i = 0; i<b.length; i++){
            b[i] = list.get(i);
        }
        return b;
    }
    //把byte二进制字符串，根据flag判断是否把byte转为8位的二进制，flag 为true时切割为8位的，如果否表示原来的byte是最后一个可能不满8位，便返回原来的二进制
    public static String byteTobitStr(byte b,boolean flag){
        int temp = b;
        if (flag){
            temp|=256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length()-8);

        }
        return str;
    }

    /**
     * 进行赫夫曼编码压缩的方法
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //先统计每一个byte出现的次数，并放入一个集合中
        List<Node> nodes = getNodes(bytes);
        //创建一个赫夫曼树
        Node tree = createHuffmanTree(nodes);
        //创建一个赫夫曼编码表
        Map<Byte,String> huffCodes = getCodes(tree);
        //编码
        byte[] b = zip(bytes,huffCodes);
        return b;
    }

    /**
     * 进行1赫夫曼编码
     * @param bytes
     * @param huffCodes
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        //把需要压缩的数组处理成一个二进制字符串
        for (byte b :bytes){
            sb.append(huffCodes.get(b));
        }
        //定义长度
        int len ;
        if (sb.length()%8==0){
            len = sb.length()/8;
        }else {
            len = sb.length()/8 + 1;
        }
        //用于存储压缩后的byte
        byte[] nb = new byte[len];
        //记录新byte的位置
        int index =0;
        for (int i = 0; i < sb.length(); i+=8){
            String strbyte;
            if (i+8>sb.length()){
                strbyte = sb.substring(i);
            }else {
                strbyte = sb.substring(i,i+8);
            }
            byte byt = (byte) Integer.parseInt(strbyte,2);
            nb[index] = byt;
            index++;
        }
        return nb;
    }

    //用于临时存储路径
    static StringBuilder sb = new StringBuilder();
    //用于临时存储编码
    static Map<Byte,String> huffCodes = new HashMap<>();
    /**
     * 根据赫夫曼树获取赫夫曼编码
     * @param tree
     * @return
     */
    private static Map<Byte, String> getCodes(Node tree) {
        if (tree==null){
            return null;
        }
        getCodes(tree.left, "0",sb);
        getCodes(tree.right, "1",sb);
        return huffCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.data==null){
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb2);
        }else {
            huffCodes.put(node.data,sb2.toString());
        }
    }

    /**
     * 创建赫夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size()>1) {
            //排序
            Collections.sort(nodes);
            //取出两个权值最低的二叉树
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            //创建一棵新的二叉树
            Node parent = new Node(null, left.weight + right.weight);
            //把之前取出来的两棵二叉树设置为新创建的二叉树的子树
            parent.left = left;
            parent.right = right;
            //把前面取出来的两棵二叉树删掉
            nodes.remove(left);
            nodes.remove(right);
            //把新创建的二叉树放入集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 把byte数组转为node集合
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        //存储每一个byte出现了多少次
        Map<Byte,Integer> counts = new HashMap<>();
        //统计每一个byte出现的次数
        for (byte b:bytes){
            Integer count = counts.get(b);
            if (count==null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        //把每一个键值对转为Node对象
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
}
