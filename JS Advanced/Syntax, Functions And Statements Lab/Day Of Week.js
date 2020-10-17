function solve(day){
    const weekdaysMap = {
        'Monday': 1,
        'Tuesday': 2,
        'Wednesday': 3,
        'Thursday': 4,
        'Friday': 5,
        'Saturday': 6,
        'Sunday': 7,
    }

    let result = weekdaysMap[day];
    
    if (typeof(result) === 'undefined'){
        result = 'error';
    }

    return result;
}

console.log(
    solve('Monday'),
    solve('Friday'),
    solve('Invalid')
);
