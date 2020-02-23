package com.dalingjia.JVM;

/**
 * 1, 对象可以在被GC时自我拯救
 * 2, 这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 */
public class FinallizeEscapeGC {

    public static FinallizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes , I am staill alive！");
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method executed!");
        FinallizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinallizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null){
           SAVE_HOOK.isAlive();
        }else {
            System.out.println("no , I am dead! ");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no , I am dead! ");
        }
    }
}
