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

let today = new Date()
let year = today.getFullYear()
let month = today.getMonth() + 1
let date = today.getDate()

$('.confirm').click(function (e){
    e.preventDefault()
    calculator.updateDisplay()
    let arr = [icon_name, calculator.displayElement.value, year+'-'+month+'-'+date]
    let iconImage = null
    $.ajax({
        url: "/calculator/sendmoney",
        data: "arr="+ arr,
        type: "POST",
        success : function (){
            if (icon_name === 'public-transport') {
                iconImage = "<div class='icons' id='public-transport'>" +
                    "<i class='fas fa-bus fa-2x'></i>" +
                    "</div>"
            } else if(icon_name === 'lunch'){
                iconImage = "<div class='icons' id='lunch'>" +
                    "<i class='fa fa-cutlery fa-2x'></i>" +
                    "</div>"
            } else if(icon_name === 'snack'){
                iconImage = "<div class='icons' id='snack'>" +
                    "<i class='fas fa-cookie fa-2x'></i>" +
                    "</div>"
            } else if(icon_name === 'coffee'){
                iconImage = "<div class='icons' id='coffee'>" +
                    "<i class='fas fa-coffee fa-2x'></i>" +
                    "</div>"
            }

            $(opener.document).find(".entire-frame").append(
                "<div class='my-daily-expend'>"
                + "<span class='my-daily-expend-sentence-span'>"+iconImage+"</span>"
                + "<span class='my-daily-expend-money-span'>"+String(calculator.displayElement.value)+"???"+"</span>"
                + "</div>"
            )

            opener.parent.location.reload()
            window.close()
        }
    })
})



