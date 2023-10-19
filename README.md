# Atendimento ao Cliente
Central de relacionamento para atender diversos tipos de solicitações dos clientes. Os principais tipos de solicitações são: Problemas com cartão e contratação de empréstimo. 

## Utilização:

_Entrada de solicitações:_<br />
POST /api/solicitacoes

_Exemplos de post:_<br />
```json
{
    "assunto": "Problemas com cartão"
}
```
```json
{
    "assunto": "Contratação de empréstimo"
}
```
```json
{
    "assunto": "Outros assuntos"
}
```

_Obter o status das filas:_<br />
GET /api/solicitacoes/status

_Obter as solicitações pendentes:_<br />
GET /api/solicitacoes/pendentes<br /><br />


## Software desenvolvido em relação ao seguinte cenário proposto

1. **Tipos de Solicitações:** Reconhecer os tipos de solicitações "Problemas com cartão" e "Contratação de empréstimo", além de outros assuntos não especificados;<br /><br />
1. **Times de Atendimento:** Organizar os atendentes em três times: Cartões, Empréstimos e Outros Assuntos;<br /><br />
1. **Distribuição de Solicitações:** Distribuir as solicitações para o time correto com base no assunto da solicitação;<br /><br />
1. **Política de Atendimento:** Cada atendente pode atender até 3 pessoas simultaneamente. Se todos os atendentes de um time estiverem ocupados, as solicitações são enfileiradas e distribuídas assim que um atendente estiver disponível;<br /><br />
1. **API REST:** Disponibiliza uma API REST para adicionar solicitações, obter o status das filas e visualizar solicitações pendentes;<br /><br />
1. **Persistência:** O software não persiste os dados;<br /><br />
1. **Linguagem:** O software foi desenvolvido em Java.<br /><br />


## Algumas considerações:

- **Simulação de Atendimento:** Quando uma solicitação é distribuída para um atendente, ela é considerada "atendida" após 1 minuto. Em um cenário real, o atendimento levaria algum tempo. Uma melhoria seria tornar a finalização do atendimento manual e liberar o atendente após essa conclusão;

- **Notificações:** Seria útil notificar o cliente quando sua solicitação estiver sendo atendida ou se houver algum atraso significativo;

- **Escalabilidade:** Se o número de solicitações for muito alto, pode ser necessário considerar a escalabilidade do software, talvez usando uma abordagem baseada em eventos ou mensagens;

- **Persistência:** Embora o desafio não exija persistência, em um cenário real, seria essencial persistir as solicitações e o status dos atendentes para garantir que nenhuma solicitação seja perdida em caso de falha do sistema;

- **Testes:** Foi implementado um teste simples, em um cenário real, seria importante ter uma cobertura de testes mais completa, incluindo testes de integração e testes de carga;

- **Segurança:** A API atualmente não possui autenticação ou autorização. Seria essencial adicionar medidas de segurança para garantir que apenas clientes autorizados possam adicionar solicitações e que apenas administradores possam visualizar o status das filas.


