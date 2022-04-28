package StringSource;

import java.util.Random;

public class DummyData {
    String[] nouns = {"cat", "dog", "elephant", "lizard", "person", "bear", "bird", "dolphin", "cobra", "snake", "panda"};
    String[] verbs = {"jumps onto", "eats", "hops onto", "leaps onto", "smacks", "bites", "chases", "runs away from",
                        "tickles", "yells at", "runs to", "scoffs at"};
    String[] adjectives = {"playfully", "aggressively", "softly", "masterfully", "delicately", "slowly", "gracefully",
                            "tragically", "hastily", "fondly", "mercilessly", "gratefully"};
    Random random = new Random();

    String getRandomNoun() { return nouns[random.nextInt(nouns.length)]; }
    String getRandomVerb() { return verbs[random.nextInt(verbs.length)]; }
    String getRandomAdjective() { return adjectives[random.nextInt(adjectives.length)]; }
}
