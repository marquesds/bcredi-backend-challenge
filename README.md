O valor do empréstimo deve estar entre R$ 30.000,00 e R$ 3.000.000,00 - OK
O empréstimo deve ser pago em no mínimo 2 anos e no máximo 15 anos - OK
Todos os proponentes devem ser maiores de 18 anos - OK
Dever haver no mínimo 1 garantia de imóvel por proposta
A soma do valor das garantias deve ser maior ou igual ao dobro do valor do empréstimo
As garantias de imóvel dos estados PR, SC e RS não são aceitas - OK

Em caso de eventos repetidos, considere o primeiro evento
Por exemplo, ao receber o evento ID 1 e novamente o mesmo evento, descarte o segundo evento
Em caso de eventos atrasados, considere sempre o evento mais novo
Por exemplo, ao receber dois eventos de atualização com IDs diferentes, porém o último evento tem um timestamp mais antigo do que o primeiro, descarte o evento mais antigo

Proposta aceita -> Empréstimo

Entidades
- Empréstimo
- Proposta
- Proponente
- Garantia

Use Cases
- Proposta
    - Deve haver no mínimo 2 proponentes por proposta
    - Deve haver exatamente 1 proponente principal por proposta
    - A renda do proponente principal deve ser pelo menos:
      - 4 vezes o valor da parcela do empréstimo, se a idade dele for entre 18 e 24 anos
      - 3 vezes o valor da parcela do empréstimo, se a idade dele for entre 24 e 50 anos
      - 2 vezes o valor da parcela do empréstimo, se a idade dele for acima de 50 anos