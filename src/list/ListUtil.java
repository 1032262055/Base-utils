package list;

import collection.CollectionUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author: Roc
 * @Date: 2020-03-30 16:46
 * @Description:
 */
public class ListUtil {
    /**
     * 按照list集合的某个属性值去重
     *
     * @param function 对象属性函数
     * @param <T>      对象类型
     * @return
     */
    public static <T> Predicate<T> distinctByProperty(Function<? super T, ?> function) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(function.apply(t), Boolean.TRUE) == null;
    }

    /**
     * 提取对象数据列表中某个属性列表
     *
     * @param list     对象数据列表
     * @param function 对象属性函数
     * @param <T>      对象类型
     * @param <U>      属性类型
     * @return
     */
    public static <T, U> List<U> getPropertyList(List<T> list, Function<? super T, U> function) {
        if (CollectionUtil.isEmpty(list)) {
            return null;
        }
        return list.stream().map(function).collect(Collectors.toList());
    }

}
