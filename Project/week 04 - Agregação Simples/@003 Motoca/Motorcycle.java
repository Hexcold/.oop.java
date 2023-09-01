class Motorcycle {
  private Person person; // agregacao
  private int power;
  private int time;

  // Inicia o atributo power, time com zero e person com null
  public Motorcycle(int power) {
    this.power = power;
    this.person = null;
    this.time = 0;
  }

  public int getPower() {
    return this.power;
  }

  public int getTime() {
    return this.time;
  }

  public Person getPerson() {
    return this.person;
  }

  // Comprar mais tempo
  public void buy(int time) {
    this.time += time;

  }

  // Se estiver vazio, coloca a pessoa na moto e retorna true
  public boolean enter(Person person) {
    if (this.person == null) {
      this.person = person;
      return true;
    }
    System.out.println("fail: busy motorcycle");
    return false;
  }

  public Person leave() {
    if (this.person != null) {
      System.out.println(this.person);
      this.person = null;
      return null;
    }
    System.out.println("fail: empty motorcycle");
    return null;
  }

  public void drive(int time) {
    if (this.time > 0) {
      if (person != null) {
        if (person.getAge() <= 10) {
          if (this.time < time) {
            System.out.println("fail: time finished after " + this.time + " minutes");
            this.time = 0;
            return;
          }
          this.time -= time;
        } else {
          System.out.println("fail: too old to drive");
        }
      } else {
        System.out.println("fail: empty motorcycle");
      }
    } else {
      System.out.println("fail: buy time first");
    }
  }

  // buzinar
  public void honk() {
    String pem = "P";
    for (int i = 0; i < this.power; i++) {
      pem += "e";
    }
    pem += "m";
    System.out.println(pem);
  }

  public String toString() {
    if (person != null) {
      return "power:" + this.power + ", time:" + this.time + ", person:" + "(" + person.toString() + ")";
    }
    return "power:" + this.power + ", time:" + this.time + ", person:" + "(empty)";
  }
}