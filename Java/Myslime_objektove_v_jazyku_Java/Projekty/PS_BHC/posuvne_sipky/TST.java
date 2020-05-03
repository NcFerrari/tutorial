package posuvne_sipky;

import rup.cesky.spolecne.P;

import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Barva;

public class TST
{

    public static void testOkolo()
    {
        try {
            AktivniPlatno ap = AktivniPlatno.getPlatno();
            ap.setRozmer( 5,  5 );
            Sipka s = new Sipka( 1,  3,  Barva.CERNA );
            ap.pridej( s );
            P.cekej( 250 );
            for( int i=4;   i-- > 0;  )
            {
                s.vpred();      P.cekej( 250 );
                s.vpred();      P.cekej( 250 );
                s.vlevoVbok();  P.cekej( 250 );
            }
        }catch(Exception e ) {
            e.printStackTrace( System.out );
        }
    }
    
    //+ main
    public static void main( String[] args )
    {
        testOkolo();
    }
    //- main

}

