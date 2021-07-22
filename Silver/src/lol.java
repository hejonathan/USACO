public class lol implements lmao {
    private String function = "a";

    public void sing(){
        System.out.println("hahaha");
    }
    public void dance(){
        System.out.println("tadaa");
    }
    public String sing(int a) { return "hahaha"; }

    @Override
    public String toString() {
        return "lol{" +
                "function='" + function + '\'' +
                '}'+"\n";
    }
}