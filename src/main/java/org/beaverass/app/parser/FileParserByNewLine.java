package org.beaverass.app.parser;

import org.beaverass.app.parser.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FileParserByNewLine implements Parser {

    @Override
    public Map<Integer,String> parseFile(String path) throws IOException {
        Charset charset = Charset.forName("UTF-8");

        BufferedReader reader = new BufferedReader(new FileReader(path, charset ));
        final Integer[] counter = {0};

        HashMap<Integer, String> candidates = reader.lines()
                .collect(Collectors.toMap(
                        k -> ++counter[0], //Integer.parseInt(k.trim().substring(0, 2).trim())
                        v -> v.trim().substring(0).trim(),
                        (e, r) -> e,
                        HashMap::new
                ));

        return candidates;
    }
}
