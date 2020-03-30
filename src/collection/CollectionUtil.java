package collection;

import java.util.Collection;

/**
 * @author: Roc
 * @Date: 2020-03-30 16:46
 * @Description:
 */
public final class CollectionUtil {

    /**
     * 集合判空
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 集合判非空
     *
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
