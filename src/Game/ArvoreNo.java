package Game;

/**
 *
 * @author wilso
 */
public class ArvoreNo<Objeto>
{
    private Objeto data;
    private ArvoreNo<Objeto> esquerdo,direito;
    
    public ArvoreNo(Objeto inicialData, ArvoreNo<Objeto> inicialesquerdo,ArvoreNo<Objeto> inicialdireito)
    {
        data = inicialData;
        esquerdo = inicialesquerdo;
        direito = inicialdireito;
    }

    public Objeto getData() {
        return data;
    }
       

    public void setData(Objeto data) {
        this.data = data;
    }

    public ArvoreNo<Objeto> getEsquerdo() {
        return esquerdo;
    }
    
    public Objeto getultimoEsquerdo()
    {
        if(esquerdo == null)
            return data;
        else
            return esquerdo.getultimoEsquerdo();
    }
    

    public void setEsquerdo(ArvoreNo<Objeto> esquerdo) {
        this.esquerdo = esquerdo;
    }

    public ArvoreNo<Objeto> getDireito() {
        return direito;
    }
    
    public Objeto getultimoDireito()
    {
        if(direito == null)
            return data;
        else
            return direito.getultimoDireito();
    }

    public void setDireito(ArvoreNo<Objeto> direito) {
        this.direito = direito;
    }
    
    public void inorderPrint()
    {
        if (esquerdo != null)
            esquerdo.inorderPrint();
        System.out.println(data);
        if (direito != null)
            direito.inorderPrint();
    }
    
    public boolean folha()
    {
        return (esquerdo == null) && (direito == null);
    }
    
    public void preorderPrint()
    {
        System.out.println(data);
        if (esquerdo != null)
            esquerdo.preorderPrint();
        if (direito != null)
            direito.preorderPrint();
    }
    
    public void postorderPrint()
    {
        if (esquerdo != null)
            esquerdo.postorderPrint();
        if (direito != null)
            direito.postorderPrint();
        System.out.println(data);
    }
    
    public void print(int pos)
    {
        int i;
        
        for ( i = 1; i <= pos; i++)
            System.out.println("    ");
        System.out.println(data);
        
        if (esquerdo != null)
            esquerdo.print(pos+1);
        else if (direito != null)
        {
            for (i = 1; i <= pos+1; i++)
                System.out.println(" ");
            System.out.println("--");
        }
        
        if(direito != null)
             direito.print(pos+1);
        else if (esquerdo != null)
        {
            for (i =1; i <= pos+1; i++)
                System.out.println(" ");
            System.out.println("--");
        }
    }
    
    public ArvoreNo<Objeto> removeUltEsq()
    {
        if (esquerdo == null)
            return direito;
        else
        {
            esquerdo = esquerdo.removeUltEsq();
            return this;
        }
    }
    
    public ArvoreNo<Objeto> removeUltDir()
    {
        if (direito == null)
            return esquerdo;
        else
        {
            direito = direito.removeUltDir();
            return this;
        }
    }
    
    public static <Objeto> ArvoreNo<Objeto> copArvore(ArvoreNo<Objeto> source)
    {
        ArvoreNo<Objeto> copDir, copEsq;
        
        if (source == null)
            return null;
        else
        {
            copEsq = copArvore(source.esquerdo);
            copDir = copArvore(source.direito);
            return new ArvoreNo<Objeto>(source.data, copEsq, copDir);
        }
    }
    
    public static <Objeto> long tamArvore(ArvoreNo<Objeto> root)
    {
        if (root == null )
            return 0;
        else
            return 1 + tamArvore(root.esquerdo) + tamArvore(root.direito);        
    }
    
    
}
