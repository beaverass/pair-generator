package org.beaverass.app.parser;

import org.beaverass.app.parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FileParserBySemicolon implements Parser {

    @Override
    public Map<Integer, String> parseFile(String path) throws IOException {
        Charset charset = Charset.forName("UTF-8");//из-за него некорректно выводится кирилица

        BufferedReader reader = new BufferedReader(new FileReader(path, charset));
        final Integer[] counter = {0};
        String[] split = reader.readLine().trim().split(";");

        HashMap<Integer, String> candidates = Arrays.stream(split).collect(Collectors.toMap(
                k -> ++counter[0],
                v -> v.trim(),
                (e, r) -> e,
                HashMap::new
        ));

        return candidates;
    }
}
