package picard.util;

import htsjdk.samtools.util.IOUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Stream;

public class CloudEnabledTest {

    @Test(groups = "cloud")
    public void testWeCanReadACloudFile() throws IOException {
        try (Stream<String> lines = Files.lines(IOUtil.getPath(GCloudTestUtils.getTestInputPath() + "nio/big.txt"))) {
            final Optional<String> matchedLine = lines.limit(1)
                    .filter(l -> l.contains("Adventures of Sherlock Holmes"))
                    .findFirst();
            Assert.assertTrue(matchedLine.isPresent());
        }

    }
}
