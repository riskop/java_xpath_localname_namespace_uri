package hu.riskop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Files;
import java.nio.file.Paths;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { Extractor.class })
public class ExtractorTest {

    @Autowired
    Extractor extractor;

    @Test
    public void testExtractTitle() throws Exception {
        String result = extractor.extractObjectInTitleInDoc(Files.readString(Paths.get("src/test/resources/a.xml")));
        System.out.println("result: " + result);
        result = extractor.extractObjectInTitleInDoc(Files.readString(Paths.get("src/test/resources/b.xml")));
        System.out.println("result: " + result);
    }

}
