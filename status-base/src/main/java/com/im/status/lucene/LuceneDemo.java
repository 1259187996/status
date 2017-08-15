//package com.im.status.lucene;
//
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.standard.StandardAnalyzer;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
//import org.apache.lucene.document.TextField;
//import org.apache.lucene.index.DirectoryReader;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.queryparser.classic.QueryParser;
//import org.apache.lucene.search.IndexSearcher;
//import org.apache.lucene.search.Query;
//import org.apache.lucene.search.ScoreDoc;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.RAMDirectory;
//import org.apache.lucene.util.Version;
//
///**
// * Created by zhizhuang.yang on 2017/8/14.
// */
//public class LuceneDemo {
//
//    private static final Version version = Version.LUCENE_4_9;
//
//    public static void main(String[] args) throws Exception{
//        Analyzer analyzer = new StandardAnalyzer(version);
//
//        // Store the index in memory:
//        Directory directory = new RAMDirectory();
//        // To store an index on disk, use this instead:
//        //Directory directory = FSDirectory.open("/tmp/testindex");
//
//        IndexWriterConfig config = new IndexWriterConfig(version, analyzer);
//        IndexWriter iwriter = new IndexWriter(directory, config);
//        Document doc = new Document();
//        Document doc2 = new Document();
//        String text = "This is the text to be indexed.";
//        String text2 = "This is the text to be indexed22222.";
//
//        doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
//        doc2.add(new Field("fieldname", text2, TextField.TYPE_STORED));
//        iwriter.addDocument(doc);
//        iwriter.addDocument(doc2);
//        iwriter.close();
//
//
//        // Now search the index:
//        DirectoryReader ireader = DirectoryReader.open(directory);
//        IndexSearcher isearcher = new IndexSearcher(ireader);
//
//        // Parse a simple query that searches for "text":
//        QueryParser parser = new QueryParser(version, "fieldname", analyzer);
//        Query query = parser.parse("text");
//        ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
//        // Iterate through the results:
//        for (int i = 0; i < hits.length; i++) {
//            Document hitDoc = isearcher.doc(hits[i].doc);
//            System.out.println("This is the text to be indexed="+hitDoc.get("fieldname"));
//        }
//        ireader.close();
//        directory.close();
//    }
//}
