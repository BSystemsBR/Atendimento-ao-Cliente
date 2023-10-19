# Atendimento ao Cliente
Central de relacionamento para atender diversos tipos de solicitações dos clientes. Os principais tipos de solicitações são: Problemas com cartão e contratação de empréstimo. 

<h3>Utilização:</h3>

POST: Entrada de solicitações:<br />
/api/solicitacoes

Exemplos de post:<br />
{ "assunto": "Problemas com cartão" }
{ "assunto": "Contratação de empréstimo" }
{ "assunto": "Outros assuntos" }

GET: Obter o status das filas:<br />
/api/solicitacoes/status

GET: Obter as solicitações pendentes:<br />
/api/solicitacoes/pendentes

<br />
<h3>Software desenvolvido em relação ao seguinte cenário proposto:</h3>

<strong>1. Tipos de Solicitações:</strong> Reconhecer os tipos de solicitações "Problemas com cartão" e "Contratação de empréstimo", além de outros assuntos não especificados.

<strong>2. Times de Atendimento:</strong> Organizar os atendentes em três times: Cartões, Empréstimos e Outros Assuntos.

<strong>3. Distribuição de Solicitações:</strong> O software distribui as solicitações para o time correto com base no assunto da solicitação.

<strong>4. Política de Atendimento:</strong> Cada atendente pode atender até 3 pessoas simultaneamente. Se todos os atendentes de um time estiverem ocupados, as solicitações são enfileiradas e distribuídas assim que um atendente estiver disponível.

<strong>5. API REST:</strong> O software disponibiliza uma API REST para adicionar solicitações, obter o status das filas e visualizar solicitações pendentes.

<strong>6. Persistência:</strong> O software não persiste os dados, conforme solicitado.

<strong>7. Linguagem:</strong> O software foi desenvolvido em Java.

<br />
<h3>O software atende a todos os requisitos especificados no cenário proposto. No entanto, há algumas considerações:</h3>

<strong>Simulação de Atendimento:</strong> Atualmente, quando uma solicitação é distribuída para um atendente, ela é considerada "atendida" após 1 minuto. Em um cenário real, o atendimento levaria algum tempo. Uma melhoria seria tornar a finalização do atendimento manual e liberar o atendente após essa conclusão.

<strong>Notificações:</strong> Em um cenário real, seria útil notificar o cliente quando sua solicitação estiver sendo atendida ou se houver algum atraso significativo.

<strong>Escalabilidade:</strong> Se o número de solicitações for muito alto, pode ser necessário considerar a escalabilidade do software, talvez usando uma abordagem baseada em eventos ou mensagens.

<strong>Persistência:</strong> Embora o cenário não exija persistência, em um cenário real, seria essencial persistir as solicitações e o status dos atendentes para garantir que nenhuma solicitação seja perdida em caso de falha do sistema.

<strong>Testes:</strong> Foi implementado um teste simples, em um cenário real, seria importante ter uma cobertura de testes mais completa, incluindo testes de integração e testes de carga.

<strong>Segurança:</strong> A API atualmente não possui autenticação ou autorização. Seria essencial adicionar medidas de segurança para garantir que apenas clientes autorizados possam adicionar solicitações e que apenas administradores possam visualizar o status das filas.


<strong>Conclusão</strong>: O software desenvolvido atende bem ao cenário proposto. No entanto, para um uso real, devemos considerar as melhorias e considerações mencionadas.
