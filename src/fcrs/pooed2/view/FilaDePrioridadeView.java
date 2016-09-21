package fcrs.pooed2.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import fcrs.pooed2.exception.BarraFuraoException;
import fcrs.pooed2.exception.FilaVaziaException;
import fcrs.pooed2.filadeprioridade.CaixaNormal;
import fcrs.pooed2.filadeprioridade.CaixaRapido;
import fcrs.pooed2.filadeprioridade.CentralDeImpressao;
import fcrs.pooed2.filadeprioridade.FilaDePrioridades;
import fcrs.pooed2.filadeprioridade.Furao;
import fcrs.pooed2.filadeprioridade.Gestante;
import fcrs.pooed2.filadeprioridade.Idoso;
import fcrs.pooed2.model.ItensProperty;
import fcrs.pooed2.util.Mensagens;

/**
*
* @author Josimar Junior
*/

public class FilaDePrioridadeView extends Application {

	private AnchorPane pane;
	private Label lbTitulo, lbTamanhoFila, lbNumeroTamanhoFila, lbPrioridade,
			lbNomeDono;
	private TextField tfNome;
	private ComboBox<String> cbPrioridade;
	private Button btInsere, btRemove, btTopo, btMostraFila, btRepeteChamada;
	private TableView<ItensProperty> table;

	private FilaDePrioridades fila = new FilaDePrioridades();

	private void initCompontens() {
		pane = new AnchorPane();
		pane.setPrefSize(711, 497);
		lbTitulo = new Label("Fila de Prioridades");
		lbTitulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

		lbTamanhoFila = new Label("Tamanho da Fila:");
		lbTamanhoFila.setFont(new Font(15));

		lbNumeroTamanhoFila = new Label();
		lbNumeroTamanhoFila.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
		lbNumeroTamanhoFila.setText(String.valueOf(fila.size()));

		lbNomeDono = new Label("Nome:");
		lbNomeDono.setFont(Font.font("Tahoma", 15));

		tfNome = new TextField();
		tfNome.setPromptText("Digite o nome do dono...");
		tfNome.setPrefWidth(200);
		tfNome.setFont(Font.font("Tahoma", 15));

		lbPrioridade = new Label("Prioridade:");
		lbPrioridade.setFont(Font.font("Tahoma", 15));

		cbPrioridade = new ComboBox();
		cbPrioridade.getItems().addAll("Caixa Normal", "Gestante", "Idoso",
				"Caixa Rápido", "Furão");
		cbPrioridade.setValue("Caixa Normal");
		cbPrioridade.getStyleClass().add("cbPrioridade");

		btInsere = new Button("Inserir na fila");
		btInsere.setFont(Font.font("Tahoma", 15));
		btInsere.getStyleClass().add("btInsere");

		btRemove = new Button("Remover da fila");
		btRemove.setFont(Font.font("Tahoma", 15));
		btRemove.getStyleClass().add("btRemove");

		btTopo = new Button("Topo da fila");
		btTopo.setFont(Font.font("Tahoma", 15));
		btTopo.getStyleClass().add("btTopo");

		btMostraFila = new Button("Mostrar fila");
		btMostraFila.setFont(Font.font("Tahoma", 15));
		btMostraFila.getStyleClass().add("btMostraFila");

		btRepeteChamada = new Button("Repetir chamada");
		btRepeteChamada.setFont(Font.font("Tahoma", 15));
		btRepeteChamada.getStyleClass().add("btRepeteChamada");

		table = new TableView<>();

		TableColumn<ItensProperty, String> senha = new TableColumn("Senha");
		TableColumn<ItensProperty, String> prioridade = new TableColumn(
				"Prioridade");
		TableColumn<ItensProperty, String> nomeDono = new TableColumn(
				"Nome do Dono");

		senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		senha.setSortable(false);

		prioridade
				.setCellValueFactory(new PropertyValueFactory<>("prioridade"));
		prioridade.setSortable(false);

		nomeDono.setCellValueFactory(new PropertyValueFactory<>("nomeDono"));
		nomeDono.setSortable(false);

		senha.setPrefWidth(200);
		prioridade.setPrefWidth(200);
		nomeDono.setPrefWidth(311);

		table.getColumns().addAll(senha, prioridade, nomeDono);

		pane.getChildren().addAll(lbTitulo, lbTamanhoFila, lbNumeroTamanhoFila,
				lbNomeDono, tfNome, lbPrioridade, cbPrioridade, btInsere,
				btRemove, btTopo, btMostraFila, btRepeteChamada, table);
	}

	private void initLayout() {
		lbTitulo.setLayoutX((pane.getWidth() - lbTitulo.getWidth()) / 2);
		lbTitulo.setLayoutY(20);

		lbTamanhoFila.setLayoutX(30);
		lbTamanhoFila.setLayoutY(70);

		lbNumeroTamanhoFila.setLayoutX(150);
		lbNumeroTamanhoFila.setLayoutY(72);

		lbNomeDono.setLayoutX(30);
		lbNomeDono.setLayoutY(115);

		tfNome.setLayoutX(80);
		tfNome.setLayoutY(110);

		lbPrioridade.setLayoutX(400);
		lbPrioridade.setLayoutY(115);

		cbPrioridade.setLayoutX(480);
		cbPrioridade.setLayoutY(110);

		btInsere.setLayoutX(30);
		btInsere.setLayoutY(180);

		btRemove.setLayoutX(150);
		btRemove.setLayoutY(180);

		btTopo.setLayoutX(285);
		btTopo.setLayoutY(180);

		btMostraFila.setLayoutX(395);
		btMostraFila.setLayoutY(180);

		btRepeteChamada.setLayoutX(560);
		btRepeteChamada.setLayoutY(180);

		table.setPrefSize(pane.getWidth(), 255);
		table.setLayoutX(0);
		table.setLayoutY(250);

	}

	private void inserir() {
		if (tfNome.getText().isEmpty()) {
			Mensagens.mensagemAlerta("Digite o nome do dono!");
		} else {
			String op = cbPrioridade.getValue().toString();
			String dono = tfNome.getText();
			try {
				switch (op) {
				case "Caixa Normal":
					fila.enfileirar(new CaixaNormal(dono));
					break;
				case "Gestante":
					fila.enfileirar(new Gestante(dono));
					break;
				case "Idoso":
					fila.enfileirar(new Idoso(dono));
					break;
				case "Caixa Rápido":
					fila.enfileirar(new CaixaRapido(dono));
					break;
				case "Furão":
					fila.enfileirar(new Furao(dono));
					break;
				}
				lbNumeroTamanhoFila.setText(String.valueOf(fila.size()));

				Mensagens
						.mensagemInformacao("Dono inserido na fila com sucesso!");
				tfNome.setText("");
				cbPrioridade.setValue("Caixa Normal");
				preencherTabela();
			} catch (BarraFuraoException ex) {
				Mensagens.mensagemErro(ex.getMessage());
			}
		}
	}

	private void initListeners() {
		btInsere.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				inserir();
			}
		});

		btRemove.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					Mensagens.mensagemInformacao("Dono(a) "
							+ fila.desenfileirar() + " foi removido da fila!");
					lbNumeroTamanhoFila.setText(String.valueOf(fila.size()));
					if (!fila.isEmpty()) {
						emitirSom("/fcrs/pooed2/som/chamada.mp3");
					}
					preencherTabela();
				} catch (FilaVaziaException ex) {
					Mensagens.mensagemErro(ex.getMessage());
				}
			}
		});

		btTopo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					Mensagens.mensagemInformacao("Topo da fila: "
							+ fila.frente().getDono() + "("
							+ fila.frente().getPrioridade() + ")");
				} catch (FilaVaziaException ex) {
					Mensagens.mensagemErro(ex.getMessage());
				}
			}
		});

		btMostraFila.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				CentralDeImpressao.imprimir(fila);
			}
		});

		tfNome.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				inserir();
			}
		});

		btRepeteChamada.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					emitirSom("/fcrs/pooed2/som/repetir-chamada.mp3");
				} catch (FilaVaziaException ex) {
					Mensagens.mensagemErro(ex.getMessage());
				}
			}
		});
	}

	private void emitirSom(String caminhoSom) throws FilaVaziaException {
		if (fila.isEmpty()) {
			throw new FilaVaziaException("Fila vazia!");
		}
		Media media = new Media(FilaDePrioridadeView.class.getResource(
				caminhoSom).toExternalForm());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
	}

	private void preencherTabela() {
		fila.getListaPrioridade();
	}

	@Override
	public void start(Stage stage) throws Exception {
		initCompontens();
		initListeners();
		table.setItems(fila.getListaPrioridade());
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("/fcrs/pooed2/css/style.css");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Fila de Prioridades");
		stage.getIcons().add(
				new Image(getClass().getResourceAsStream(
						"/fcrs/pooed2/imagens/fila.png")));
		stage.show();
		initLayout();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
