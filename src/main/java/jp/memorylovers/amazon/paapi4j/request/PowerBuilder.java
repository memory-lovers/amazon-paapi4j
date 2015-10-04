package jp.memorylovers.amazon.paapi4j.request;

import lombok.AllArgsConstructor;

/**
 * builder for Power<br>
 * Unsupported for 'binding', 'language'
 *
 * @see <a href="https://images-na.ssl-images-amazon.com/images/G/09/associates/paapi/dg/index.html?rw_useCurrentProtocol=1">詳細サーチ構文</a>
 */
public class PowerBuilder {

    private final static String AFTER = "after";
    private final static String ASIN = "ASIN";
    private final static String AUTHOR = "author";
    private final static String AUTHOR_BEGINS = "author-begins";
    private final static String AUTHOR_EXACT = "author-exact";
    //TODO binding
    private final static String DURING = "during";
    private final static String ISBN = "ISBN";
    private final static String KEYWORDS = "keywords";
    private final static String KEYWORDS_BEGIN = "keywords-begin";
    //TODO language
    private final static String PUBDATE = "pubdate";
    private final static String PUBLISHER = "publisher";
    private final static String SUBJECT = "subject";
    private final static String SUBJECT_BEGINS = "subject-begins";
    private final static String SUBJECT_WORDS_BEGINS = "subject-words-begins";
    private final static String TITLE = "title";
    private final static String TITLE_BEGINS = "title-begins";
    private final static String TITLE_WORDS_BEGINS = "title-words-begins";

    public static PowerBuilder builder() {
        return new PowerBuilder();
    }

    public PowerOperator and(IPowerCond left, IPowerCond right) {
        return new PowerOperator("and", left, right);
    }

    public PowerOperator or(IPowerCond left, IPowerCond right) {
        return new PowerOperator("or", left, right);
    }

    public PowerCond asin(String asin) {
        return new PowerCond(ASIN, asin);
    }

    public PowerCond author(String title) {
        return new PowerCond(AUTHOR, title);
    }

    public PowerCond authorBegins(String word) {
        return new PowerCond(AUTHOR_BEGINS, word);
    }

    public PowerCond authorExact(String word) {
        return new PowerCond(AUTHOR_EXACT, word);
    }

    public PowerCond isbn(String isbn) {
        return new PowerCond(ISBN, isbn);
    }

    public PowerCond keywords(String keywords) {
        return new PowerCond(KEYWORDS, keywords);
    }

    public PowerCond keywordsBegin(String keywords) {
        return new PowerCond(KEYWORDS_BEGIN, keywords);
    }

    public PowerCond pubdateAfter(int year) {
        return new PowerCond(PUBDATE, AFTER + " " + String.valueOf(year));
    }

    public PowerCond pubdateAfter(int year, int month) {
        return new PowerCond(PUBDATE, AFTER + " " + String.valueOf(month) + "-" + String.valueOf(year));
    }

    public PowerCond pubdateDuring(int year) {
        return new PowerCond(PUBDATE, DURING + " " + String.valueOf(year));
    }

    public PowerCond pubdateDuring(int year, int month) {
        return new PowerCond(PUBDATE, AFTER + " " + String.valueOf(month) + "-" + String.valueOf(year));
    }

    public PowerCond publisher(String publisher) {
        return new PowerCond(PUBLISHER, publisher);
    }

    public PowerCond subject(String subject) {
        return new PowerCond(SUBJECT, subject);
    }

    public PowerCond subjectBegins(String subject) {
        return new PowerCond(SUBJECT_BEGINS, subject);
    }

    public PowerCond subjectWordsBegins(String subject) {
        return new PowerCond(SUBJECT_WORDS_BEGINS, subject);
    }

    public PowerCond title(String title) {
        return new PowerCond(TITLE, title);
    }

    public PowerCond titleBegins(String word) {
        return new PowerCond(TITLE_BEGINS, word);
    }

    public PowerCond titleWordsBegins(String word) {
        return new PowerCond(TITLE_WORDS_BEGINS, word);
    }


    public interface IPowerCond {
    }

    public interface IPowerOperator extends IPowerCond {
    }

    @AllArgsConstructor
    public class PowerCond implements IPowerCond {
        private String key;
        private String value;

        @Override
        public String toString() {
            return key + ": " + value;
        }
    }

    @AllArgsConstructor
    public class PowerOperator implements IPowerOperator {
        private String operator;
        private IPowerCond left;
        private IPowerCond right;

        @Override
        public String toString() {
            return "(" + left + " " + operator + " " + right + ")";
        }
    }
}
