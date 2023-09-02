public class Car {
    public int pass; // Passageiros
    public int passMax; // limite de Passageiros
    public int gas; // tanque
    public int gasMax; // limite do tanque
    public int km; // quantidade de quilometragem

    public Car() {
        this.passMax = 2;
        this.gasMax = 100;
    }

    Car(int pass, int gas) {
        this.pass = pass;
        passMax = 100;
        this.gas = gas;
        gasMax = 100;
    }

    public String toString() {
        return "pass: " + this.pass + ", " + "gas: " + this.gas + ", " + "km: " + this.km;
    }

    public void enter() {
        if (pass < passMax) {
            pass++;
        } else {
            Solver.write("fail: limite de pessoas atingido");
        }
    }

    public void leave() {
        if (pass > 0) {
            pass--;
        } else {
            Solver.write("fail: nao ha ninguem no carro");
        }
    }

    public void fuel(int gas) {
        this.gas += gas;
        if (this.gas > this.gasMax) {
            this.gas = this.gasMax;
        }
    }

    public void drive(int km) {
        if (pass > 0) {
            if (this.gas == 0) {
                Solver.write("fail: tanque vazio");
            } else if (km <= this.gas) {
                this.km += km;
                this.gas -= km;
            } else {
                Solver.write("fail: tanque vazio apos andar " + this.gas + " km");
                this.km += this.gas;
                this.gas = 0;
            }
        } else {
            Solver.write("fail: nao ha ninguem no carro");
        }
    }
}