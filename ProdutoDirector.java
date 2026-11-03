public class ProdutoDirector {

    public void construirLivroPadrao(Produto.Builder builder) {
        builder.categoria("Livros")
               .preco(39.90)
               .descricao("Obra literária física");
    }

    public void construirEbookGratuito(Produto.Builder builder) {
        builder.categoria("E-books")
               .preco(0.0)
               .descricao("Download digital gratuito");
    }
}
