package UseCases;

import java.util.List;

public interface Response<T> {

    List<T> data();
    void add(List<T> data);
}

