public class Main {

    public static void main(String[] args) {

        System.out.println("=== Exercício 1 ===");
        Produto completo = new Produto.Builder()
                .id(1L)
                .nome("Notebook")
                .descricao("Notebook 15 polegadas")
                .preco(3500.00)
                .categoria("Informática")
                .build();
        System.out.println(completo);

        Produto parcial = new Produto.Builder()
                .id(2L)
                .nome("Mouse")
                .build();
        System.out.println(parcial);

        System.out.println("\n=== Exercício 2 ===");
        ProdutoDirector director = new ProdutoDirector();

        Produto.Builder builderLivro = new Produto.Builder();
        director.construirLivroPadrao(builderLivro);
        Produto livro = builderLivro.id(10L).nome("Dom Casmurro").build();
        System.out.println(livro);

        Produto.Builder builderEbook = new Produto.Builder();
        director.construirEbookGratuito(builderEbook);
        Produto ebook = builderEbook.id(11L).nome("Memórias Póstumas (PDF)").build();
        System.out.println(ebook);

        System.out.println("\n=== Exercício 3 ===");

        try {
            new Produto.Builder().nome("Sem id").build();
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("[3a - id nulo] " + e.getMessage());
        }
        try {
            new Produto.Builder().id(3L).nome("   ").build();
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("[3a - nome vazio] " + e.getMessage());
        }

        try {
            new Produto.Builder().id(4L).nome("Caneta").preco(-5.0).build();
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("[3b - preço negativo] " + e.getMessage());
        }

        try {
            new Produto.Builder().id(5L).nome("E-book pago")
                    .categoria("E-books").preco(19.90).build();
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("[3c - e-book com preço] " + e.getMessage());
        }
    }
}
