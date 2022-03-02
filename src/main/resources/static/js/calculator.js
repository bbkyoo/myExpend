class Calculator {
    constructor(displayElement) {
        this.displayElement = displayElement
        this.displayContent = ''
        this.clear()
    }

    appendNumber(number) {
        this.displayContent += number
    }

    appendOperator(operator){
        this.displayContent += operator
    }

    updateDisplay(){
        this.displayElement.value = this.displayContent
    }

    clear(){
        this.displayContent = ''
        this.displayElement.value = 0
    }

    compute(){
        this.displayContent = eval(this.displayContent
            .replace('\u00D7', '*')
            .replace('\u00F7', '/')
        )
    }
}

const buttons = document.querySelectorAll('button')
const displayElement = document.querySelector('input')

const calculator = new Calculator(displayElement)

buttons.forEach(button => {
    button.addEventListener('click', () => {
        switch (button.dataset.type) {
            case 'operator':
                calculator.appendOperator(button.innerText)
                calculator.updateDisplay()
                break
            case 'ac':
                calculator.clear()
                break
            case 'equals':
                calculator.compute()
                calculator.updateDisplay()
                break
            default:
                calculator.appendNumber(button.innerText)
                calculator.updateDisplay()
                break
        }
    })
})

$('.confirm').click(function (){
    calculator.updateDisplay()

    $.ajax({
        url: "/calculator/sendMoney",
        data: calculator.displayElement.value,
        type: "POST"


    })

    // $('.entire-frame').append("<div class='my-daily-block'>" +
    //     "<div class='my-daily-block-icons'>"+"<i class=\'fas fa-bus fa-2x\'></i>"+"</div>"+
    //     "<div class='my-daily-block-text'>bus</div>"+
    //     "<div class='my-daily-block-money'>{calculator.displayElement.value}</div>"+
    //     "</div>")
})



