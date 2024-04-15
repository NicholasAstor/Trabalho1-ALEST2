def coletarDinheiro(arquivo):
    linhas = arquivo.strip().split('\n')
    soma = 0
    direcoes = {'right': (0, 1), 'left': (0, -1), 'down': (1, 0), 'up': (-1, 0)}
    
    posicao_carro = None
    for l, linha in enumerate(linhas):
        if linha.strip() and linha.strip()[0] == '-':
            posicao_carro = (0, l)
            break

    if posicao_carro:
        direcao = direcoes['right']  # Começa indo para a direita
        coluna, linha = posicao_carro

        while True:
            if linha < 0 or linha >= len(linhas) or coluna < 0 or coluna >= len(linhas[linha]):
                break

            char_atual = linhas[linha][coluna]

            if char_atual == '#':
                break

            elif char_atual == '-' or char_atual == '|':  #continua na mesma direção
                linha += direcao[0]
                coluna += direcao[1]

            elif char_atual == '/': 
                if direcao == direcoes['up']:
                    direcao = direcoes['right']
                elif direcao == direcoes['down']:
                    direcao = direcoes['left']
                elif direcao == direcoes['right']:
                    direcao = direcoes['up']
                elif direcao == direcoes['left']:
                    direcao = direcoes['down']
                linha += direcao[0]
                coluna += direcao[1]

            elif char_atual == '\\': 
                if direcao == direcoes['up']:
                    direcao = direcoes['left']
                elif direcao == direcoes['down']:
                    direcao = direcoes['right']
                elif direcao == direcoes['right']:
                    direcao = direcoes['down']
                elif direcao == direcoes['left']:
                    direcao = direcoes['up']
                linha += direcao[0]
                coluna += direcao[1]

            elif char_atual.isdigit():
                numero = ''
                while char_atual.isdigit():
                    numero += char_atual
                    linha += direcao[0]
                    coluna += direcao[1]
                    if 0 <= linha < len(linhas) and 0 <= coluna < len(linhas[linha]):
                        char_atual = linhas[linha][coluna]
                    else:
                        break
                soma += int(numero)

    return soma

# Ler o arquivo
nome_arquivo = input("Digite o nome do arquivo: ")
with open(nome_arquivo, 'r') as file:
    arquivo = file.read()

# Chamar a função coletarDinheiro com o conteúdo do arquivo
print(coletarDinheiro(arquivo))