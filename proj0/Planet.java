public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;

    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final  double G = 6.67e-11;


    public Planet(double xp, double yP, double xV,
                  double yV, double m, String img){
        this.xxPos = xp;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet other){
        double xxDif = this.xxPos - other.xxPos;
        double yyDif = this.yyPos - other.yyPos;
        return Math.sqrt(xxDif * xxDif + yyDif * yyDif);
    }
    public double calcForceExertedBy(Planet other){
        double dist = calcDistance(other);
        return G * this.mass * other.mass / (dist * dist);
    }
    public double calcForceExertedByX(Planet other){
        double dist = calcDistance(other);
        double F = calcForceExertedBy(other);
        double xxDiff = other.xxPos - this.xxPos;
        return F * xxDiff / dist;
    }
    public double calcForceExertedByY(Planet other){
        double dist = calcDistance(other);
        double F = calcForceExertedBy(other);
        double yyDiff = other.yyPos - this.yyPos;
        return F * yyDiff / dist;
    }
    public double calcNetForceExertedByX(Planet[] others){
        double totalForce = 0;
        for (Planet other : others) {
            if (this.equals(other)) {
                continue;
            }
            totalForce += calcForceExertedByX(other);
        }
        return totalForce;
    }
    public double calcNetForceExertedByY(Planet[] others){
        double totalForce = 0;
        for (Planet other : others) {
            if (this.equals(other)) {
                continue;
            }
            totalForce += calcForceExertedByY(other);
        }
        return totalForce;
    }
    public void update(double duration, double xxForce, double yyForce){
        double ax = xxForce / this.mass;
        double ay = yyForce / this.mass;
        this.xxVel += ax * duration;
        this.yyVel += ay * duration;
        this.xxPos += this.xxVel * duration;
        this.yyPos += this.yyVel * duration;

    }
    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/" + imgFileName);
    }
}
