package vn.edu.iuh.fit.examples;

import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class NounDetectionExample {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos"); // Thêm 'tokenize' trước 'pos'
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        String inputWord = "";

        // Tạo CoreDocument chứa từ đầu vào
        Annotation annotation = new Annotation(inputWord);

        // Áp dụng pipeline lên CoreDocument
        pipeline.annotate(annotation);

        // Lấy danh sách từ được gắn nhãn từ loại
        List<CoreLabel> tokens = annotation.get(CoreAnnotations.TokensAnnotation.class);

        if (!tokens.isEmpty()) {
            CoreLabel token = tokens.get(0);
            String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            if (pos.startsWith("N")) {
                System.out.println(inputWord + " là danh từ.");
            } else {
                System.out.println(inputWord + " không phải là danh từ.");
            }
        } else {
            System.out.println("Không thể xác định từ loại của từ.");
        }
    }
}