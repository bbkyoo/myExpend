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
const displayElement = document.getElementById("calculator-display-for-advanced")

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

const icons = document.querySelectorAll(".icons")
let icon_name = null

icons.forEach(icon => {
    icon.addEventListener('click', () => {
        switch (icon.id) {
            case 'public-transport':
                icon_name = 'public-transport'
                break
            case 'lunch':
                icon_name = 'lunch'
                break
            case 'snack':
                icon_name = 'snack'
                break
            case 'coffee':
                icon_name = 'coffee'
                break
            default:
                icon_name = null
                break
        }
    })
})

$('.confirm').click(function (e){
    e.preventDefault()
    calculator.updateDisplay()
    let arr = [icon_name, calculator.displayElement.value]
    $.ajax({
        url: "/calculator/sendmoney",
        data: "arr="+ arr,
        type: "POST",
        success : function (){
            window.close()
        }
    })

    // $('.entire-frame').append("<div class='my-daily-block'>" +
    //     "<div class='my-daily-block-icons'>"+"<i class=\'fas fa-bus fa-2x\'></i>"+"</div>"+
    //     "<div class='my-daily-block-text'>bus</div>"+
    //     "<div class='my-daily-block-money'>{calculator.displayElement.value}</div>"+
    //     "</div>")
})



