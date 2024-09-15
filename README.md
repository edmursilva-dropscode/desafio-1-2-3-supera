# Desafios Técnicos Java – Supera

## Descrição
Este projeto consiste em 3 desafios técnicos implementados em Java, abrangendo diferentes aspectos da programação, desde manipulação de strings e lógica matemática. Os desafios foram desenvolvidos como parte de um processo seletivo e utilizam testes automatizados para validar as soluções.

## Estrutura do Projeto
O projeto é composto pelos seguintes diretórios e arquivos principais:

  - `desafio1/`: Contém a implementação do Desafio Resistores – Código de Cores
  - `desafio2/`: Contém a implementação do Desafio Flores de Samambaia
  - `desafio3/`: Contém a implementação do Desafio Matriz Espiral
  - `gerenciamentodetarefas/`: Contém a implementação da API de Gerenciamento de Tarefas

## Desafio 1: Resistores – Código de Cores

### Classe ResistorConverter
A classe ResistorConverter é responsável por converter valores de resistência em ohms para a sequência de cores correspondente em um resistor.

#### Métodos:
- `converterParaCores(String valor)`: Converte o valor de ohms para a sequência de cores do resistor.

### Regras de Negócio
1. Valores menores que 1000 ohms são formatados como números simples.
2. Valores entre 1000 e 999999 ohms são divididos por 1000 e representados com "k".
3. Valores de 1000000 ohms ou mais são divididos por 1000000 e representados com "M".
4. A sequência de cores sempre termina com "dourado" para representar a tolerância.

## Desafio 2: Flores de Samambaia

### Classe FlorSamambaia
A classe FlorSamambaia simula a tentativa de um caçador de colher uma flor mágica.

#### Métodos:
- `tentativaDesenhar(int r1, int x1, int y1, int r2, int x2, int y2)`: Determina se o caçador consegue colher a flor com base na posição e tamanho de dois círculos.

### Regras de Negócio
1. O círculo do caçador deve envolver completamente o círculo da flor para ser bem-sucedido.
2. Se os círculos não se intersectam ou se intersectam parcialmente, o caçador falha.

## Desafio 3: Matriz Espiral

### Classe MatrizEspiral
A classe MatrizEspiral transforma uma matriz bidimensional em um array unidimensional, percorrendo a matriz em espiral no sentido horário.

#### Métodos:
- `percorrerMatrizEspiral(int[][] matriz)`: Transforma a matriz em um array percorrendo-a em espiral.

### Regras de Negócio
1. A matriz é percorrida da borda externa para o centro.
2. O percurso é feito no sentido horário.
3. Matrizes vazias devem ser tratadas adequadamente.

### Ferramenta utilizada
. IDE - SpringToolSuite4,
. JAVA

<br>
<h1 align="center">
    <img src="./desafio1-2-3.png">
</h1>
