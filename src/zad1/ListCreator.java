package zad1;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator<T> {
    private List<T> list;
    private List<T> resultList;

    private ListCreator(final List<T> list) {
        this.list = list;
    }

    public static <T> ListCreator<T> collectFrom(final List<T> list){
        return new ListCreator<>(list);
    }

    public ListCreator<T> when(final Predicate <T> predicate){
        resultList = new ArrayList<>();

        for (final T element : this.list) {
            if(predicate.test(element)){
                resultList.add(element);
            }
        }
        this.list = resultList;
        return this;
    }

    public <R> List<T> mapEvery(final Function<T,R> function) {
        resultList = new ArrayList<>();

        for (final T element : this.list)
            resultList.add((T)function.apply(element));

        return this.list = resultList;
    }
}