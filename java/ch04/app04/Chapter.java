package app04;
class Chapter {
    String title;
    int numberOfPages;

    public void review() {
        Page page = new Page();
        int sentenceCount = page.numberOfSentences;
        int pageNumber = page.getPageNumber();
    }
}