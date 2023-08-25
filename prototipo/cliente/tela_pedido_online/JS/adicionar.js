/*
    Relação dos índices
    0 == Jaqueta   |  Tempo == 2 dias
    1 == Blusa     |  Tempo == 2 dias
    2 == Calça     |  Tempo == 2 dias
    3 == Meia      |  Tempo == 1 dia
    4 == Bermuda   |  Tempo == 1 dia
    5 == Camisa    |  Tempo == 1 dia
    6 == Íntima    |  Tempo == 1 dia
    7 == Sutiã     |  Tempo == 1 dia
*/
let quantidadeRoupas = [0, 0, 0, 0, 0, 0, 0, 0];

// ========== Meia ==========
function aumentaMeia()
{
    qtdMeia++;
    totMeia += 0.5;

    quantidadeRoupas[3]++;

    let quantidade = document.getElementById("qtd-meia");
    quantidade.innerHTML = "Quantidade: " + qtdMeia;

    let valor = document.getElementById("valor-meia");
    valor.innerHTML = "Valor total:  " + totMeia + " R$";

    aumentaTotal(0.5);

    if(qtdMeia == 1)
        atualizarTempoTotal();
}

function diminuiMeia()
{
    if(qtdMeia > 0)
    {
        qtdMeia--;
        totMeia -= 0.5;

        quantidadeRoupas[3]--;
            
        let quantidade = document.getElementById("qtd-meia");
        quantidade.innerHTML = "Quantidade: " + qtdMeia;

        let valor = document.getElementById("valor-meia");
        valor.innerHTML = "Valor total:  " + totMeia + " R$";

        diminuiTotal(0.5);

        if(qtdMeia == 0)
            atualizarTempoTotal();
    }
}

const upMeia = document.getElementById("meia-up");
const downMeia = document.getElementById("meia-down");

upMeia.addEventListener("click", aumentaMeia);
downMeia.addEventListener("click", diminuiMeia);

let qtdMeia = 0;
let totMeia = 0;

// ========== Calça ==========
function aumentaCalca()
{
    qtdCalca++;
    totCalca += 1;

    quantidadeRoupas[2]++;

    let quantidade = document.getElementById("qtd-calca");
    quantidade.innerHTML = "Quantidade: " + qtdCalca;

    let valor = document.getElementById("valor-calca");
    valor.innerHTML = "Valor total:  " + totCalca + " R$";

    aumentaTotal(1);

    if(qtdCalca == 1)
        atualizarTempoTotal();
}

function diminuiCalca()
{
    if(qtdCalca > 0)
    {
        qtdCalca--;
        totCalca -= 1;

        quantidadeRoupas[2]--;
            
        let quantidade = document.getElementById("qtd-calca");
        quantidade.innerHTML = "Quantidade: " + qtdCalca;

        let valor = document.getElementById("valor-calca");
        valor.innerHTML = "Valor total:  " + totCalca + " R$";

        diminuiTotal(1);

        if(qtdCalca == 0)
            atualizarTempoTotal();
    }
}

const upCalca = document.getElementById("calca-up");
const downCalca = document.getElementById("calca-down");

upCalca.addEventListener("click", aumentaCalca);
downCalca.addEventListener("click", diminuiCalca);

let qtdCalca = 0;
let totCalca = 0;

// ========== Bermuda ==========
function aumentaBermuda()
{
    qtdBermuda++;
    totBermuda += 0.75;

    quantidadeRoupas[4]++;

    let quantidade = document.getElementById("qtd-bermuda");
    quantidade.innerHTML = "Quantidade: " + qtdBermuda;

    let valor = document.getElementById("valor-bermuda");
    valor.innerHTML = "Valor total:  " + totBermuda + " R$";

    aumentaTotal(0.75);

    if(qtdBermuda == 1)
        atualizarTempoTotal();
}

function diminuiBermuda()
{
    if(qtdBermuda > 0)
    {
        qtdBermuda--;
        totBermuda -= 0.75;

        quantidadeRoupas[4]--;
            
        let quantidade = document.getElementById("qtd-bermuda");
        quantidade.innerHTML = "Quantidade: " + qtdBermuda;

        let valor = document.getElementById("valor-bermuda");
        valor.innerHTML = "Valor total:  " + totBermuda + " R$";

        diminuiTotal(0.75);

        if(qtdBermuda == 0)
            atualizarTempoTotal();
    }
}

const upBermuda = document.getElementById("bermuda-up");
const downBermuda = document.getElementById("bermuda-down");

upBermuda.addEventListener("click", aumentaBermuda);
downBermuda.addEventListener("click", diminuiBermuda);

let qtdBermuda = 0;
let totBermuda = 0;

// ========== Blusa ==========
function aumentaBlusa()
{
    qtdBlusa++;
    totBlusa += 1;

    quantidadeRoupas[1]++;

    let quantidade = document.getElementById("qtd-blusa");
    quantidade.innerHTML = "Quantidade: " + qtdBlusa;

    let valor = document.getElementById("valor-blusa");
    valor.innerHTML = "Valor total:  " + totBlusa + " R$";

    aumentaTotal(1);

    if(qtdBlusa == 1)
        atualizarTempoTotal();
}

function diminuiBlusa()
{
    if(qtdBlusa > 0)
    {
        qtdBlusa--;
        totBlusa -= 1;

        quantidadeRoupas[1]--;
            
        let quantidade = document.getElementById("qtd-blusa");
        quantidade.innerHTML = "Quantidade: " + qtdBlusa;

        let valor = document.getElementById("valor-blusa");
        valor.innerHTML = "Valor total:  " + totBlusa + " R$";

        diminuiTotal(1);

        if(qtdBlusa == 0)
            atualizarTempoTotal();
    }
}

const upBlusa = document.getElementById("blusa-up");
const downBlusa = document.getElementById("blusa-down");

upBlusa.addEventListener("click", aumentaBlusa);
downBlusa.addEventListener("click", diminuiBlusa);

let qtdBlusa = 0;
let totBlusa = 0;

// ========== Camisa ==========
function aumentaCamisa()
{
    qtdCamisa++;
    totCamisa += 0.75;

    quantidadeRoupas[5]++;

    let quantidade = document.getElementById("qtd-camisa");
    quantidade.innerHTML = "Quantidade: " + qtdCamisa;

    let valor = document.getElementById("valor-camisa");
    valor.innerHTML = "Valor total:  " + totCamisa + " R$";

    aumentaTotal(0.75);

    if(qtdCamisa == 1)
        atualizarTempoTotal();
}

function diminuiCamisa()
{
    if(qtdCamisa > 0)
    {
        qtdCamisa--;
        totCamisa -= 0.75;

        quantidadeRoupas[5]--;
            
        let quantidade = document.getElementById("qtd-camisa");
        quantidade.innerHTML = "Quantidade: " + qtdCamisa;

        let valor = document.getElementById("valor-camisa");
        valor.innerHTML = "Valor total:  " + totCamisa + " R$";

        diminuiTotal(0.75);

        if(qtdCamisa == 0)
            atualizarTempoTotal();
    }
}

const upCamisa = document.getElementById("camisa-up");
const downCamisa = document.getElementById("camisa-down");

upCamisa.addEventListener("click", aumentaCamisa);
downCamisa.addEventListener("click", diminuiCamisa);

let qtdCamisa = 0;
let totCamisa = 0;

// ========== Roupa íntima ==========
function aumentaIntima()
{
    qtdIntima++;
    totIntima += 0.5;

    quantidadeRoupas[6]++;

    let quantidade = document.getElementById("qtd-intima");
    quantidade.innerHTML = "Quantidade: " + qtdIntima;

    let valor = document.getElementById("valor-intima");
    valor.innerHTML = "Valor total:  " + totIntima + " R$";

    aumentaTotal(0.5);

    if(qtdIntima == 1)
        atualizarTempoTotal();
}

function diminuiIntima()
{
    if(qtdIntima > 0)
    {
        qtdIntima--;
        totIntima -= 0.5;

        quantidadeRoupas[6]--;
            
        let quantidade = document.getElementById("qtd-intima");
        quantidade.innerHTML = "Quantidade: " + qtdIntima;

        let valor = document.getElementById("valor-intima");
        valor.innerHTML = "Valor total:  " + totIntima + " R$";

        diminuiTotal(0.5);

        if(qtdIntima == 0)
            atualizarTempoTotal();
    }
}

const upIntima = document.getElementById("intima-up");
const downIntima = document.getElementById("intima-down");

upIntima.addEventListener("click", aumentaIntima);
downIntima.addEventListener("click", diminuiIntima);

let qtdIntima = 0;
let totIntima = 0;

// ========== Sutiã ==========
function aumentaSutia()
{
    qtdSutia++;
    totSutia += 0.5;

    quantidadeRoupas[7]++;

    let quantidade = document.getElementById("qtd-sutia");
    quantidade.innerHTML = "Quantidade: " + qtdSutia;

    let valor = document.getElementById("valor-sutia");
    valor.innerHTML = "Valor total:  " + totSutia + " R$";

    aumentaTotal(0.5);

    if(qtdSutia == 1)
        atualizarTempoTotal();
}

function diminuiSutia()
{
    if(qtdSutia > 0)
    {
        qtdSutia--;
        totSutia -= 0.5;

        quantidadeRoupas[7]--;
            
        let quantidade = document.getElementById("qtd-sutia");
        quantidade.innerHTML = "Quantidade: " + qtdSutia;

        let valor = document.getElementById("valor-sutia");
        valor.innerHTML = "Valor total:  " + totSutia + " R$";

        diminuiTotal(0.5);

        if(qtdSutia == 0)
            atualizarTempoTotal();
    }
}

const upSutia = document.getElementById("sutia-up");
const downSutia = document.getElementById("sutia-down");

upSutia.addEventListener("click", aumentaSutia);
downSutia.addEventListener("click", diminuiSutia);

let qtdSutia = 0;
let totSutia = 0;

// ========== Jaqueta ==========
function aumentaJaqueta()
{
    qtdJaqueta++;
    totJaqueta += 1.5;

    quantidadeRoupas[0]++;

    let quantidade = document.getElementById("qtd-jaqueta");
    quantidade.innerHTML = "Quantidade: " + qtdJaqueta;

    let valor = document.getElementById("valor-jaqueta");
    valor.innerHTML = "Valor total:  " + totJaqueta + " R$";

    aumentaTotal(1.5);

    if(qtdJaqueta == 1)
        atualizarTempoTotal();
}

function diminuiJaqueta()
{
    if(qtdJaqueta > 0)
    {
        qtdJaqueta--;
        totJaqueta -= 1.5;

        quantidadeRoupas[0]--;
            
        let quantidade = document.getElementById("qtd-jaqueta");
        quantidade.innerHTML = "Quantidade: " + qtdJaqueta;

        let valor = document.getElementById("valor-jaqueta");
        valor.innerHTML = "Valor total:  " + totJaqueta + " R$";

        diminuiTotal(1.5);

        if(qtdJaqueta == 0)
            atualizarTempoTotal();
    }
}

const upJaqueta = document.getElementById("jaqueta-up");
const downJaqueta = document.getElementById("jaqueta-down");

upJaqueta.addEventListener("click", aumentaJaqueta);
downJaqueta.addEventListener("click", diminuiJaqueta);

let qtdJaqueta = 0;
let totJaqueta = 0;

// ========== Confirmar ==========
function aumentaTotal(valor = 0)
{
    valorTotal += valor;

    let totalPedido = document.getElementById("valor-total");
    totalPedido.innerHTML = "Valor Total: " + valorTotal + " R$";
}

function diminuiTotal(valor = 0)
{
    if(valorTotal > 0)
    {
        valorTotal -= valor;

        let totalPedido = document.getElementById("valor-total");
        totalPedido.innerHTML = "Valor Total: " + valorTotal + " R$";
    }
}

function atualizarTempoTotal()
{
    let i = 0;
    let atualizou = false;

    for(i = 0; i < 3; i++)
    {
        if(quantidadeRoupas[i] > 0)
        {
            tempoTotal = 2;
            atualizou = true;
            break;
        }
    }

    if(!atualizou)
    {
        for(i = 3; i < 8; i++)
        {
            if(quantidadeRoupas[i] > 0)
            {
                tempoTotal = 1;
                atualizou = true;
                break;
            }
        }
    }

    if(!atualizou)
        tempoTotal = 0;

    let tempoPedido = document.getElementById("tempo-total");

    if(tempoTotal == 0 || tempoTotal == 1)
        tempoPedido.innerHTML = "Tempo Total: " + tempoTotal + " dia";
    else
        tempoPedido.innerHTML = "Tempo Total: " + tempoTotal + " dias";
}

let valorTotal = 0;
let tempoTotal = 0;

let botaoConfirmar= document.getElementById('botaoConfirmar');
let botaoCancelar= document.getElementById('botaoCancelar');

botaoConfirmar.addEventListener('click', function(verificaBotao){
    let valido = false;
    for(let cont=0; cont<quantidadeRoupas.length; cont++){
        if (quantidadeRoupas[cont]!=0){
            valido = true;
        }
    }
    if(!valido){
        verificaBotao.preventDefault();
        alert('Por favor, inclua peças de roupa no pedido para que ele possa ser confirmado!');
    } else{
        alert("Seu pedido foi confirmado! O número do pedido é: 568.")
    }
});