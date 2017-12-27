package cn.zjj.db;

/**
 * 使用ThreadLocal技术来记录当前线程中的数据源的key
 */
public class DynamicDataSourceHolder {


    public static final ThreadLocal<DynamicDataSourceGlobal> holder = new ThreadLocal<>();

    private DynamicDataSourceHolder(){}

    public static void putDataSource(DynamicDataSourceGlobal dataSource) {
        holder.set(dataSource);
    }

    public static DynamicDataSourceGlobal getDataSource() {
        return holder.get();
    }

    public static void clearDataSource() {
        holder.remove();
    }


}
