package temporizador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.sql.*;


import temporizador.Equipes;
public class Cronometro extends WindowAdapter implements ActionListener{
    class Timer extends Thread {
        public void run(){
            while(cronometroRodando){
                try{
                    segundos++;
                    Thread.sleep(1000);

                    setTempo(segundos);
                } catch(InterruptedException e){
                    System.out.println(e);
                    break;
                }
            }
        }
    }
        private Timer timer;
	private Frame janela, janelaRelatorio;
	private Panel painelInterface, painelBotoes, painelRelatorioInterface;
	private Label lEquipe, lTempo, lVolta1, lVolta2, lTotal, lPiloto, lRelatorio, lDados;
	private TextField tEquipe, tPiloto;
	private Button bIniciar, bVolta, bFim, bRelatorio, bSalvar, bAtualizar;
	private Vector vCronometro;
        private int segundos = 1;
	private int posicao;
        private int voltas = 0;
        private boolean cronometroRodando = false;
        private String tempoVolta1;
        private String tempoVolta2;
        

	public Cronometro(){
            
            //Parte Visual da Tela Principal
            
		vCronometro=new Vector();
		janela = new Frame();
		janela.setTitle("Cronometro");
		janela.setSize(400, 500);
                janela.setBackground(new Color(240, 240, 240));
                janela.setLayout(new BorderLayout(10, 10));
	 	janela.addWindowListener(this);


		painelInterface = new Panel();
		painelInterface.setBackground(new Color(240, 240, 240));
		painelInterface.setSize(400, 500);
		painelInterface.setLocation(10,80);
		painelInterface.setLayout(null);


		painelBotoes = new Panel();
		painelBotoes.setBackground(new Color(64,128,128));
		painelBotoes.setSize(350,34);
		painelBotoes.setLocation(10,344);
		painelBotoes.setLayout(new FlowLayout());


		lEquipe = new Label("Equipe:");
                lPiloto = new Label("Piloto:");
		lTempo = new Label("00:00:00");
		lVolta1 = new Label("Volta 1:");
                lVolta2 = new Label("Volta 2:");
                lTotal = new Label("Tempo total:");
   
                tEquipe = new TextField(40);
                tPiloto =  new TextField(50);
                
		Panel painelEquipe = new Panel(new FlowLayout(FlowLayout.LEFT, 5, 0));
                painelEquipe.setBackground(new Color(240, 240, 240));
                Panel painelPiloto = new Panel(new FlowLayout(FlowLayout.LEFT, 5, 0));
                painelPiloto.setBackground(new Color(240, 240, 240));

                
                lEquipe.setFont(new Font("Arial", Font.BOLD, 14));
                tEquipe.setFont(new Font("Arial", Font.PLAIN, 14));
                tEquipe.setPreferredSize(new Dimension(250, 25));
                lPiloto.setFont(new Font("Arial", Font.BOLD, 14));
                tPiloto.setFont(new Font("Arial", Font.PLAIN, 14));
                tPiloto.setPreferredSize(new Dimension(250, 25));


                painelEquipe.add(lEquipe);
                painelEquipe.add(tEquipe);
                painelPiloto.add(lPiloto);
                painelPiloto.add(tPiloto);


                painelEquipe.setBounds(20, 30, 350, 50);
                painelPiloto.setBounds(20, 80, 350, 50);
		lTempo.setBounds(150, 200, 150, 30); 
                lTempo.setFont(new Font("Arial", Font.BOLD, 18));

                lVolta1.setBounds(20, 230, 200, 20);
                lVolta2.setBounds(20, 260, 200, 20);
                lTotal.setBounds(20, 290, 200, 20);


		
		painelInterface.add(painelEquipe);
                painelInterface.add(painelPiloto);
                painelInterface.add(lTempo);
                painelInterface.add(lVolta1);
                painelInterface.add(lVolta2);
                painelInterface.add(lTotal);
		


		bIniciar = new Button("Iniciar");
                bIniciar.addActionListener(this);
                bIniciar.setFont(new Font("Arial", Font.BOLD, 12));
                
		bVolta = new Button("Volta");
		bVolta.addActionListener(this);
                bVolta.setFont(new Font("Arial", Font.BOLD, 12));
                
		bFim = new Button("Fim");
		bFim.addActionListener(this);
		bFim.setFont(new Font("Arial", Font.BOLD, 12));
                
                bSalvar=new Button("Salvar");
		bSalvar.addActionListener(this);
		bSalvar.setFont(new Font("Arial", Font.BOLD, 12));
                
                bRelatorio=new Button("Relatorio");
		bRelatorio.addActionListener(this);
                bRelatorio.setFont(new Font("Arial", Font.BOLD, 12));

		painelBotoes.add(bIniciar);
		painelBotoes.add(bVolta);
		painelBotoes.add(bFim);
		painelBotoes.add(bSalvar);
		painelBotoes.add(bRelatorio);


		janela.add(painelInterface);
		janela.add(painelBotoes);


		bSalvar.setEnabled(false);
		bRelatorio.setEnabled(false);
		bFim.setEnabled(false);
                bVolta.setEnabled(false);
	}
        
        //--------------------------------------------------------------------------
        
        //Parte Lógica do Cronometro
        
        public void setTempo(int totalSegundos) {
            int horas = totalSegundos / 3600;
            int minutos = (totalSegundos % 3600) / 60;
            int segundos = totalSegundos % 60;
            String tempoFormatado = String.format("%02d:%02d:%02d", horas, minutos, segundos);
            lTempo.setText(tempoFormatado);
        }


        private int tempoParaSegundos(String tempo) {
            String[] partes = tempo.split(":");
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);
            int segundos = Integer.parseInt(partes[2]);
            return horas * 3600 + minutos * 60 + segundos;
        }

        private String segundosParaTempo(int totalSegundos) {
            int horas = totalSegundos / 3600;
            int minutos = (totalSegundos % 3600) / 60;
            int segundos = totalSegundos % 60;
            return String.format("%02d:%02d:%02d", horas, minutos, segundos);
        }


	public void setVolta1() {
            lVolta1.setText("Volta 1: " + lTempo.getText());
            tempoVolta1 = lTempo.getText();
        }

        public void setVolta2() {
            lVolta2.setText("Volta 2: " + lTempo.getText());
            tempoVolta2 = lTempo.getText();
        }

	
        private void calcularTempoTotal() {
            if (tempoVolta1 != null && tempoVolta2 != null) {
                int segVolta1 = tempoParaSegundos(tempoVolta1);
                int segVolta2 = tempoParaSegundos(tempoVolta2);
                int totalSegundos = segVolta1 + segVolta2;
                lTotal.setText("Tempo total: " + segundosParaTempo(totalSegundos));
            }
        }
	public String getEquipe(){
		return tEquipe.getText();
	}
        public String getPiloto() {
                return tPiloto.getText();
        }
        public String getTotal(){
		return lTotal.getText();
	}
	
	public void actionPerformed(ActionEvent e)	{
		Button b=(Button)e.getSource();
		if (b==bIniciar) {
                    if (timer == null || !timer.isAlive()){
                        timer = new Timer();
                        timer.start();
                    }
                    this.botaoIniciar();
                }
		else if (b==bVolta)	   this.botaoVolta();
		else if (b==bFim)   this.botaoFim();
		else if (b==bSalvar) this.botaoSalvar();
		else if (b==bRelatorio)  this.botaoRelatorio();
                
	}
      
	void botaoIniciar() {
            if (tEquipe.getText().trim().isEmpty() || tPiloto.getText().trim().isEmpty()) {
                return; 
            }

            if (!cronometroRodando) {
                if (timer == null || !timer.isAlive()) {
                    timer = new Timer();
                    timer.start();
                }
                
                cronometroRodando = true;
                segundos = 0;
                setTempo(0);
                tEquipe.setEnabled(false);
                tPiloto.setEnabled(false);
                tempoVolta1 = null;
                tempoVolta2 = null;
                lVolta1.setText("Volta 1:");
                lVolta2.setText("Volta 2:");
                lTotal.setText("Tempo total:");
            }

            bVolta.setEnabled(true);
            bFim.setEnabled(true);
            bSalvar.setEnabled(false);
            bRelatorio.setEnabled(false);
            bIniciar.setEnabled(false);
        }

        public void botaoVolta() {
            if (!cronometroRodando) return;

            voltas++;

            if (voltas == 1) {
                tempoVolta1 = lTempo.getText();
                setVolta1();
                segundos = 1;
                lTempo.setText("00:00:00");
            } 
            else if (voltas == 2) {
                tempoVolta2 = lTempo.getText();
                setVolta2();
                calcularTempoTotal();
                bVolta.setEnabled(false);
                timer.interrupt();
                bSalvar.setEnabled(true);
            }  
        }

	void botaoFim() {

            if (timer != null) {
                timer.interrupt();
                timer = null;
            }

            cronometroRodando = false;
            voltas = 0;
            segundos = 0;
            setTempo(0);

            lVolta1.setText("Volta 1:");
            lVolta2.setText("Volta 2:");
            lTotal.setText("Tempo total:");

            bIniciar.setEnabled(true);
            bVolta.setEnabled(false);
            bFim.setEnabled(false);
            bSalvar.setEnabled(false);
            bRelatorio.setEnabled(false);
            tEquipe.setText("");
            tEquipe.setEnabled(true);
            tPiloto.setText("");
            tPiloto.setEnabled(true);
        }

	void botaoSalvar() {
		vCronometro.addElement(new Equipes(getEquipe(), getPiloto(), getTotal()));
                bRelatorio.setEnabled(true);
                bSalvar.setEnabled(false);
                Connection con=conecta();
                //con=conecta();
                try {
                    
                    Statement st=con.createStatement();
                    
                    int resultado = st.executeUpdate("INSERT INTO RELATORIOS (NOME_EQUIPE, NOME_PILOTO, TEMPO_TOTAL) "
                            + "VALUES "
                            + "('"+getEquipe()+"','"+getPiloto()+"','"+getTotal()+"');");
                    st.close();
                    //rs.close();
                    con.close();
                    
                    System.out.println("Registro salvo.");
                    this.botaoFim();
                    
                } catch(SQLException sql) {
                    
                    System.out.println("Não salvo.");
                    
                }
        }

	void botaoRelatorio() {
            
            //Parte Visual do Relatório
            
            bRelatorio.setEnabled(false);
            vCronometro = new Vector();

            // Usar a variável de instância em vez de criar uma local
            this.janelaRelatorio = new Frame();
            this.janelaRelatorio.setTitle("Cronometro");
            this.janelaRelatorio.setSize(400, 500);
            this.janelaRelatorio.setBackground(new Color(240, 240, 240));
            this.janelaRelatorio.setLayout(new BorderLayout(10, 10));
            this.janelaRelatorio.addWindowListener(this);
            this.janelaRelatorio.setVisible(true);
            
            this.painelRelatorioInterface = new Panel();
            this.painelRelatorioInterface.setBackground(new Color(240, 240, 240));
            this.painelRelatorioInterface.setSize(400, 500);
            this.painelRelatorioInterface.setLocation(10, 80);
            this.painelRelatorioInterface.setLayout(null);
            this.janelaRelatorio.add(painelRelatorioInterface);
            
            painelBotoes = new Panel();
            painelBotoes.setBackground(new Color(64,128,128));
            painelBotoes.setSize(350,34);
            painelBotoes.setLocation(10,344);
            painelBotoes.setLayout(new FlowLayout());
            this.janelaRelatorio.add(painelBotoes);
            
            lRelatorio = new Label ("Relatório");
            lRelatorio.setFont(new Font("Arial", Font.BOLD, 20));
            lRelatorio.setBounds(5, 30, 50, 70);
            painelBotoes.add(lRelatorio);
            
            this.lDados = new Label ("");
            lDados.setFont(new Font("Arial", Font.PLAIN, 15));
            lDados.setBounds(5, 10, 370, 10);
            this.painelRelatorioInterface.add(lDados);
            
            bAtualizar = new Button("Atualizar");
            bAtualizar.addActionListener(this);
            bAtualizar.setFont(new Font("Arial", Font.BOLD, 12));
            painelBotoes.add(bAtualizar);
            
            
            // Parte de Consulta dos Relatórios
            
            Connection con=conecta();
            con=conecta();
            
            try {
                Statement st = con.createStatement();
                /*ResultSet rs = st.executeQuery("SELECT NOME_EQUIPE, NOME_PILOTO, TEMPO_TOTAL FROM RELATORIOS"
                        + "WHERE NOME_EQUIPE = ?"
                        + "ORDER BY TEMPO_TOTAL DESC"
                        + "LIMIT 10;");*/
                ResultSet rs = st.executeQuery("SELECT * FROM RELATORIOS;");
                con.close();
            } catch(SQLException sql) {
                System.out.println("Erro!");
            }        
	}
        
        
        //-------------------------------------------------------------------------------------------------
        
        //>>>> Seção de acesso ao Banco de Dados
        
        Connection conecta() {
            
            String url = "jdbc:mysql://localhost/bd_relatorio";
            Connection con;
            
            try {
                Class.forName("sun.idbc.odbc.JdbcOdbcDriver");
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(url, "root", "");
                return con;
                
            } catch(ClassNotFoundException cnf) {
                System.out.println("Houver um erro no DRIVER: classnotfoundexception-" + cnf);
                return null;
                
            } catch(SQLException sql) {
                System.out.println("Houver um erro no SQL:sqlexception  sql-" + sql);
                return null;
                
            } 
        }
        

	public void windowClosing(WindowEvent e) {
            if (e.getWindow() == janelaRelatorio) {
                // Fecha apenas a janela de relatório
                e.getWindow().dispose();
                bRelatorio.setEnabled(true);
            } 
            else if (e.getWindow() == janela) {
                // Fecha a janela principal e encerra o programa
                System.exit(0);
            }
}
	
	public void mostraAgenda(){
		janela.setVisible(true);
	}

    
    public static void main(String[] args) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_PRINTSCREEN){
                    System.out.println("print");
                    e.consume();
                    return true;
                }
                return false;
            }
        });
       
        Cronometro cronometro = new Cronometro();

        cronometro.mostraAgenda();
    }
    
}

