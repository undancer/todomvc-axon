import update from "immutability-helper";


const getAll = () => {
    return [
        {
            id: 1,
            title: 'Learn Javascript',
            completed: false
        },
        {
            id: 2,
            title: 'Learn React',
            completed: false
        },
        {
            id: 3,
            title: 'Build a React App',
            completed: false
        },
        {
            id: 4,
            title: 'Taste JavaScript',
            completed: true,
        },
        {
            id: 5,
            title: 'Buy a unicorn',
            completed: false,
        },
    ]
};

let todoCounter = 1;
const getNextId = () => {
    return getAll().length + todoCounter++;
};


const addToList = (list: Todo[], data: any) => {
    let item = Object.assign({id: getNextId()}, data);
    return list.concat([item]);

};

const updateStatus = (items: Todo[], itemId: number, completed: boolean) => {

    let index = items.findIndex((item: Todo) => item.id === itemId);

    return update(items, {
        [index]: {
            completed: {
                $set: completed
            }
        }
    })

};

const updateText = (items: Todo[], itemId: number, title: string) => {
    let index = items.findIndex((item: Todo) => item.id === itemId);

    return update(items, {
        [index]: {
            title: {
                $set: title
            }
        }
    })

};

const deleteItem = (items: any, itemId: number) => {
    let index = items.findIndex((item: any) => item.id === itemId);
    return [...items.slice(0, index), ...items.slice(index + 1)]
};

export {addToList, getAll, updateStatus, updateText, deleteItem}