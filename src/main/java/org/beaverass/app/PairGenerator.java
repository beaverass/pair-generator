package org.beaverass.app;

import org.beaverass.app.parser.Parser;
import org.beaverass.app.util.RandomIntGenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PairGenerator {

    private final Parser fileParser;

    public PairGenerator(Parser fileParser) {
        this.fileParser = fileParser;
    }

    public Map<String, String> generatePair(String path, int min) throws IOException {

        Map<Integer, String> candidates = fileParser.parseFile(path);

        Map<String, String> result = new HashMap<>();

        int candidatesSize = candidates.size();

        if(candidatesSize == 1){
            System.out.println("Участник всего один, добавьте больше учатников!");
            return result;
        }

        String randomCandidateForLastPerson = null;

        if(candidatesSize % 2 != 0){
            randomCandidateForLastPerson =
                    candidates.get(RandomIntGenerator.generate(candidatesSize, min));
        }

        while (!candidates.isEmpty()){

            if(candidates.size() == 1) {
                generatePairForLastPerson(candidates, result, randomCandidateForLastPerson);
            }

            createPair(candidates, result, candidatesSize, min );

        }

        return result;
    }

    private void generatePairForLastPerson(Map<Integer, String> candidates,
                                           Map<String, String> result, String randomCandidate){

        Set<Integer> keys = candidates.keySet();
        Integer lastCandidate = keys.iterator().next();

        while (candidates.get(lastCandidate) == randomCandidate){

            randomCandidate = result.values().stream().findAny().get();

        }

        result.put(candidates.get(lastCandidate), randomCandidate);

        candidates.remove(lastCandidate);
    }

    private void createPair(Map<Integer, String> candidates,
                            Map<String, String> result, int candidatesSize, int min) {

        int firstCandidate = RandomIntGenerator.generate(candidatesSize, min);
        int secondCandidate = RandomIntGenerator.generate(candidatesSize, min);

        boolean hasTwoRandomNums = firstCandidate != secondCandidate && candidates.containsKey(firstCandidate) && candidates.containsKey(secondCandidate);

        if(hasTwoRandomNums){
            result.put(candidates.get(firstCandidate), candidates.get(secondCandidate));
            candidates.remove(firstCandidate);
            candidates.remove(secondCandidate);
        }



    }




}
