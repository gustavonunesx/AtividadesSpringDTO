document.getElementById("produtoForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Impede o recarregamento da página

    const produto = {
        nome: document.getElementById("nome").value,
        preco: parseFloat(document.getElementById("preco").value), // <-- Aqui estava faltando a vírgula!
        quantidade: parseInt(document.getElementById("quantidade").value) // Agora está correto!
    };

    fetch("http://localhost:8080/produto", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(produto)
    })
    .then(response => {
        if (!response.ok) {
            return response.json().then(err => { throw new Error(JSON.stringify(err)); });
        }
        return response.json();
    })
    .then(data => {
        alert("Produto cadastrado com sucesso!");
        document.getElementById("produtoForm").reset(); // Limpa o formulário
        buscarProdutos(); // Atualiza a lista automaticamente
    })
    .catch(error => {
        console.error("Erro:", error);
        alert("Falha ao cadastrar o produto. Verifique o console.");
    });
});

function buscarProdutos() {
    fetch("http://localhost:8080/produto")
    .then(response => {
        if (!response.ok) {
            throw new Error("Erro ao buscar produtos");
        }
        return response.json();
    })
    .then(data => {
        const lista = document.getElementById("listaProdutos");
        lista.innerHTML = ""; // Limpa a lista antes de exibir

        data.forEach(produto => {
            const item = document.createElement("li");
            item.textContent = `${produto.id} - ${produto.nome} - R$ ${produto.preco.toFixed(2)} - Quantidade: ${produto.quantidade}`;
            lista.appendChild(item);
        });
    })
    .catch(error => {
        console.error("Erro ao buscar produtos:", error);
        alert("Erro ao buscar produtos. Verifique o console.");
    });
}
