import java.util.List;
import java.util.Set;

public class Filter implements BlackListFilter {

    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     * 
     * @param comments  list of comments; every comment
     *                  is a sequence of words, separated
     *                  by spaces, punctuation or line breaks
     * @param blackList list of words that should not
     *                  be present in a comment
     */
    // Функция для фильтрации комментариев по черному списку
    public void filterComments(List<String> comments, Set<String> blackList) {
        for (int i = 0; i < comments.size(); i++) {
            String comment = comments.get(i);
            String[] words = comment.split("\\s+"); // Разбиваем комментарий на массив слов по пробелам
            for (String word : words) {
                if (blackList.contains(word)) { // Проверяем, есть ли слово в черном списке
                    comments.remove(i); // Удаляем комментарий из списка
                    i--; // Уменьшаем i на 1. Если мы не уменьшим i на единицу, то мы потеряем следующий элемент в списке
                    break; // Прерываем цикл по словам
                }
            }
        }
    }

}
