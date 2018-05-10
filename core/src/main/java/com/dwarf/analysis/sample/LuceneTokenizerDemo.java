package com.dwarf.analysis.sample;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.analysis.Analyzer.TokenStreamComponents;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.analysis.standard.ClassicTokenizer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

public class LuceneTokenizerDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);       //向列表中添加数据
        list.add(2);        //向列表中添加数据
        list.add(3);       //向列表中添加数据
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);        //向列表中添加数据
        list1.add(3);       //向列表中添加数据
        boolean ret = list.removeAll(list1);    //从list中移除与list1相同的元素
        Iterator<Integer> it = list.iterator();   //创建迭代器
        while (it.hasNext()) {       //循环遍历迭代器
            System.out.println(it.next());    //输出集合中元素
        }


        new LuceneTokenizerDemo().testNT();
    }

    /**
     * 测试标准的分词器StandardTokenizer
     */
    public void testST(){
        Tokenizer tokenizer = new StandardTokenizer();

        tokenizer.setReader(new StringReader("这一个中文分词的例子，你可以直接运行它！IKAnalyer can analysis english text too"));

        TokenStreamComponents tsc = new TokenStreamComponents(tokenizer);
        TokenStream ts = tsc.getTokenStream();
        OffsetAttribute  offset = ts.addAttribute(OffsetAttribute.class);
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        TypeAttribute type = ts.addAttribute(TypeAttribute.class);
        try {
            ts.reset();
            while(ts.incrementToken()){
                System.out.println(term.toString() + "->" + offset.startOffset() + "-" + offset.endOffset() + "->" + type.type());
            }
            ts.end();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 测试标准的分词器ClassTokenizer
     */
    public void testCT(){
        Tokenizer tokenizer = new ClassicTokenizer();

        tokenizer.setReader(new StringReader("这一个中文分词的例子，你可以直接运行它！IKAnalyer can analysis english text too"));

        TokenStreamComponents tsc = new TokenStreamComponents(tokenizer);
        TokenStream ts = tsc.getTokenStream();
        OffsetAttribute  offset = ts.addAttribute(OffsetAttribute.class);
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        TypeAttribute type = ts.addAttribute(TypeAttribute.class);
        try {
            ts.reset();
            while(ts.incrementToken()){
                System.out.println(term.toString() + "->" + offset.startOffset() + "-" + offset.endOffset() + "->" + type.type());
            }
            ts.end();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 测试标准的分词器NGramTokenizer
     * min:1,max:2
     */
    public void testNT(){
        Tokenizer tokenizer = new NGramTokenizer();
        tokenizer.setReader(new StringReader("这一个中文分词的例子，你可以直接运行它！IKAnalyer can analysis english text too"));

        TokenStreamComponents tsc = new TokenStreamComponents(tokenizer);
        TokenStream ts = tsc.getTokenStream();
        OffsetAttribute  offset = ts.addAttribute(OffsetAttribute.class);
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        TypeAttribute type = ts.addAttribute(TypeAttribute.class);
        try {
            ts.reset();
            while(ts.incrementToken()){
                System.out.println(term.toString() + "->" + offset.startOffset() + "-" + offset.endOffset() + "->" + type.type());
            }
            ts.end();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
