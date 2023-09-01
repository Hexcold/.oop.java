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
                this.person = null;
                return this.person;
            }
            System.out.println("fail: empty motorcycle");
            return this.person;
        }

        public void drive(int time) {
            if(person != null){
                if (person.getAge() <= 10) {
                    if (this.time >= time) {
                        this.time -= time;   
                    }
                }
            }
        }

        // buzinar
        public void honk() {
            System.out.println("P");
                for(int i = 0; i <= this.power; i++){
                    System.out.println("e");
                }
            System.out.println("m");
        }

        public String toString() {
            if(person != null){
                return "power:" + this.power + ", time:" + this.time + ", person:" + "(" + person.toString() + ")";
            }
            return "power:" + this.power + ", time:" + this.time + ", person:" + "(empty)";  
        }
    }