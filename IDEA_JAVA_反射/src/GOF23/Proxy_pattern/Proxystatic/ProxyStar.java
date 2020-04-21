package GOF23.Proxy_pattern.Proxystatic;

public class ProxyStar implements Star {
    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("ProxyStar.confer");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar.signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxyStar.bookTicket");
    }

    @Override
    public void sing() {
        //代理对象唯独不能唱歌，所有需要真实对象唱歌
        //所以需要知道代理的哪个对象
        /**
         * private Star star;
         *
         *     public ProxyStar(Star star) {
         *         this.star = star;
         *     }
         */
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.sing");
    }
}
