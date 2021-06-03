package Watki;

import javafx.scene.shape.Polyline;

import static Interfejs.Main.buffor;


public class Connection extends Thread{

    private Polyline start, meta;

    public Connection(Polyline start, Polyline meta)
    {
        this.meta = meta;
        this.start = start;
    }

    @Override
    public void run()
    {
        while (!isInterrupted()) {
            if(start!=null && meta!=null)
            {
                Polaczenie();
            }

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                interrupt();
            }
        }
    }

    private void Polaczenie()
    {
        if(buffor)
        {
            buffor = false;

            System.out.println("Wyslano z: " + start.getId());

            if(start.getStroke()!= meta.getStroke()) meta.setStroke(start.getStroke());

            synchronized (this){
                if(!start.isVisible()) start.setVisible(true);
                if(!meta.isVisible()) meta.setVisible(true);
            }

            try{
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                interrupt();
            }

            System.out.println("Odebrano z: " + meta.getId());

            buffor = true;
        }
    }

}
