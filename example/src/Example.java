import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Example {

    static HashMap<String, Integer> dictionaryWordCount = new HashMap<>();

    public static void main(String[] args) {

        final String[] words = """
                The IPCC's measured assessment shows that the world needs to face up to the challenge of climate
                change, and to do so now. It is clear that climate change poses an urgent challenge, not only a
                challenge that threatens the environment but also international peace and security, prosperity and
                development. And as the Stern report showed, the economic effects of climate change on this scale
                cannot be ignored, but the costs can be limited if we act early. That is why when the world gathers
                in Bali in a few weeks time at the UN climate conference, it is vital that we launch negotiations on
                a comprehensive global agreement on tackling climate change. Britain will go into these talks with
                an ambitious agenda, building on the example we have set through the climate change bill as the
                first country to set a legally binding framework to cut carbon emissions. Our approach at Bali will
                be based on four key principles: The first is that a post-2012 agreement must meet the scale of the
                challenge, with global emissions peaking no later than 10-15 years time and reduced by at least 50
                per cent by 2050 compared to 1990 levels. Second, it must be effective. This means a binding
                regime, agreed by mutual consent, and the creation of a global carbon market to provide an
                economic incentive for low carbon investment. The third principle is fairness. Developed countries
                have historic responsibility for causing climate change, and have the greatest capacity for
                reducing emissions. So we must show leadership and take the first and largest responsibility. That
                is why I am asking the UK's independent climate change committee to report on whether our
                target of a 60 per cent reduction in emissions by 2050, already greater than most other countries,
                should be even stronger still. I will be setting out in the next few days some of the further action we
                will be taking in Britain to reduce carbon emissions, and climate change will be one of the key
                issues discussed at next week's meeting of Commonwealth leaders. Fourth, any new agreement
                must be comprehensive, addressing emissions from land use and deforestation as well as just
                energy, and addressing the urgent need to help developing countries adapt to the climate change
                which is now already damaging their development. Securing agreement based on these principles
                in the next two years will be an immense task for the international community. But we believe it is
                possible.\s
                """.split("\\s+"); //Splits the string into an array at every space

        wordCloud(words);
        getStatWords(words);

    }

    private static void getStatWords(String[] words) {

        System.out.println("Amount of words in the text: " + words.length);
        System.out.println("Amount of unique words: " + Arrays.stream(words).distinct().toList().size());
        System.out.println("Words and their total appearances: ");
        for (String word : dictionaryWordCount.keySet()) { //For all the words print them
            System.out.println(word + ": " + dictionaryWordCount.get(word));

        }

    }

    public static void wordCloud(String[] words) {
        JFrame frame = new JFrame("Word cloud");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        List<JLabel> labels = new ArrayList<>();

        frame.setSize(900, 1080);

        for (String word : words) {

            if (dictionaryWordCount.containsKey(word)) {
                dictionaryWordCount.put(word, dictionaryWordCount.get(word) + 1);
            } else {
                dictionaryWordCount.put(word, 1);
            }
        }

        for (String dictWords : dictionaryWordCount.keySet()) {

            int labelSize = dictionaryWordCount.get(dictWords) * 3; //Get the value assigned with the word
            JLabel label = new JLabel(dictWords);
            label.setFont(new Font("Times New Roman", Font.PLAIN, labelSize));
            labels.add(label);

        }
        labels.forEach(panel::add);
        frame.add(panel);
        frame.setVisible(true);
    }

}
