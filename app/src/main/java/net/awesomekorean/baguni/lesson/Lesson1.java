package net.awesomekorean.baguni.lesson;

public class Lesson1 implements Lesson{

    final static String[] wordInKorean = {"학생", "선생님", "회사원", "경찰", "의사"};
    final static String[] wordInEnglish = {"Student", "Teacher", "Office worker", "Police", "Doctor"};

    final static String[] confusingWord =  {
            "학생", "학상", "학셍", "학샌",
            "선생님", "선상님", "선셍님", "선샌님",
            "회사원", "회자원", "홰사원", "휘사원",
            "경찰", "견찰", "겅찰", "건찰",
            "의사", "위사", "의자", "의샤"};

    final static String[] sentenceInKorean = {
            "안녕하세요?",
            "제 이름은 데니예요.",
            "만나서 반가워요.",
            "저는 선생님이에요."};

    final static String[] sentenceInEnglish = {
            "Hello.",
            "My name is Danny.",
            "Nice to meet you.",
            "I'm a teacher."
    };

    final static String[] sentenceExplain = {
            "'안녕하세요?' is blablablabla...",
            "'제 이름은 데니예요.' is blablablablablabla,",
            "'만나서 반가워요.'is blablablabla",
            "저는 선생님이에요.' is blablablabla"
    };

    @Override
    public String[] getWordInKorean() {
        return wordInKorean;
    }

    @Override
    public String[] getWordInEnglish() {
        return wordInEnglish;
    }

    @Override
    public String[] getConfusingWord() {
        return confusingWord;
    }

    @Override
    public String[] getSentenceInKorean() {
        return sentenceInKorean;
    }

    @Override
    public String[] getSentenceInEnglish() {
        return sentenceInEnglish;
    }

    @Override
    public String[] getSentenceExplain() {
        return sentenceExplain;
    }
}
