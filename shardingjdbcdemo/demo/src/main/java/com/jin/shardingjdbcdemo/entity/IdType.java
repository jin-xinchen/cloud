package com.jin.shardingjdbcdemo.entity;

public enum IdType {
    AUTO(0) {
        public String getDescription() {
            return "数据库id自增";
        }
    },
    NONE(1) {
        public String getDescription() {
            return "未设置主键";
        }
    },
    INPUT(2) {
        public String getDescription() {
            return "手动输入";
        }
    },
    ID_WORKER(3) {
        public String getDescription() {
            return "默认的方式,全局唯一id";
        }
    },
    UUID(4) {
        public String getDescription() {
            return "全局唯一id uuid";
        }
    },
    ID_WORKER_STR(5) {
        public String getDescription() {
            return "ID_WORKER 字符串表示法";
        }
    };
    private int code;
    // 构造方法：enum的构造方法只能被声明为private权限或不声明权限
    private IdType(int number) { // 构造方法
        this.code = number;
    }
    public int getCode() { // 普通方法
        return code;
    } // 普通方法
    public abstract String getDescription(); // 抽象方法
    public static void main(String args[]) { // 静态方法
        for (IdType s : IdType.values()) {
            System.out.println("code: " + s.getCode() + ", description: " + s.getDescription());
        }
    }
}

