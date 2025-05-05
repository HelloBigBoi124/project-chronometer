package temporizador;

public class Equipes{
		private String equipe;
                private String volta1;
                private String volta2;
                private String total;

		public Equipes(String Equipe, String Volta1,String Volta2, String Total){
			this.equipe = Equipe;
                        this.volta1 = Volta1;
                        this.volta2 = Volta2;
                        this.total = Total;
			
		}
		
		public String getNome(){
			return this.equipe;
		}
}


