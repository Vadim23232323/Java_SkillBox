public class English {
    String text = "Most people would agree that it is great to have a pet. They are our friends, companions, family members. I have an adorable calico cat as a pet, her name is Minnie. She is two years old, we adopted her when she was just a tiny kitten.\n" +
            "\n" +
            "Calico is not a breed, it is a color pattern. A calico cat is usually white with black and orange patches on the coat. Minnie is very curious and likes to walk outdoors. We live on the ground floor, so she just jumps out of the window when she wants to take a walk.\n" +
            "\n" +
            "Our neighborhood is safe, but Minnie is still quite cautious. She does not let strangers pet her, and she always rushes back home if she notices a dog. My father made some kind of ladder for Minnie, so she can easily go out and come back. Minnie is a smart cat. I have a feeling she understands everything I say to her. She is pretty active and loves playing. Her favorite game is to wake us up at 4 a.m. by running and jumping around the apartment. Minnie is a picky eater. I know what kind of food she prefers, and she knows that I know. If for whatever reason I gave her, for example tuna (she does not like tuna), she would ignore it and demand her favorite treat.\n" +
            "\n" +
            "As most cats do, Minnie sleeps a lot during the day. We got her a cat house for her Birthday, but she prefers to sleep on my keyboard, on my father’s desk when he is working, on my mom’s lap when she is watching TV. Although, I saw her a few times sleeping in her house.\n" +
            "\n" +
            "Minnie is a beautiful cat, but I love her not for her looks. She is my good friend, and I consider her a family member. Some people say that dogs make good friends but cats do not. I would not agree with that. Neither would my cat.";

    public void getTextToWords() {
        String[] wordss = text.split("\\s+");
        String[] word, words;
        int count = 0;
        for (int i = 0; i < wordss.length; i++) {
            words = wordss[i].split("\\.");
            for (int j = 0; j < words.length; j++) {
                word = words[j].split("\\,");
                for (int k = 0; k < word.length; k++) {
                    count++;
                    System.out.println("Ñëîâî: " + (word[k]));
                }
            }
        }
        System.out.println("Âñåãî êîëè÷åñòâî ñëîâ: " + count);
    }
}

