rm(list = ls())

train <- read.csv("train.csv")
test <- read.csv("test.csv")

#Sample_Submission <- read.csv("Sample_Submission.csv")

# checking the structure of data

colnames(train)
colnames(test)

############# Data Cleaning
test$Loan_Status <- NA
complete_data <- rbind(train,test)

# Checking missing value
colSums(is.na(test)) # it seems that there are other variable as well which has missing value however 
# these are not being shown.
colSums(is.na(train))
colSums(is.na(complete_data))

# Let's check the summary again.
summary(complete_data)

levels(complete_data$Gender)

# there are other varibale like gender which has 24 missing values 
# still these are appearing as a seperate factore.

#table(complete_data$Gender)
levels(complete_data$Gender)[1] <- NA
levels(complete_data$Married)[1] <- NA
levels(complete_data$Dependents)[1] <- NA
levels(complete_data$Self_Employed)[1] <- NA

complete_data$Credit_History <- as.factor(complete_data$
                                            Credit_History)
#now check the summary again.
summary(complete_data)
# great! its done.

#Now lets check the missing value one more time.
colSums(is.na(complete_data))

colnames(complete_data)

######### exploring data ##########
library(ggvis)

hist(complete_data$LoanAmount, breaks = 100)
complete_data %>% ggvis(~LoanAmount) %>% layer_histograms
(width = 100, boundary = 0)

hist(complete_data$Loan_Amount_Term, breaks = 100)
complete_data %>% ggvis(~Loan_Amount_Term) %>% 
    layer_histograms(width = 100, boundary = 0)

plot(complete_data$Gender)
plot(complete_data$Married)
plot(complete_data$Dependents)
plot(complete_data$Education)
plot(complete_data$Self_Employed)
plot(complete_data$ApplicantIncome)
plot(complete_data$CoapplicantIncome)
plot(complete_data$LoanAmount)
plot(complete_data$Loan_Amount_Term)
plot(complete_data$Credit_History)
plot(complete_data$Property_Area)

# ###### Treating missing values using missForest Package #######
# library(missForest)
# 
# complete_data_mF1 <- missForest(complete_data[c(-1,-13)])
# complete_data_mF1$ximp
# complete_data_mF1$OOBerror
# 
# complete_data_mF2 <- missForest(complete_data[c(-1,-13)], maxiter = 5, ntree = 100, mtry = 100)
# complete_data_mF2$OOBerror
# 
# # missForest does not work out bcoz PFC is very high rate of missclassification of categorical varibales is very high
# # I am not able to bring it down

## Treating missing values

# Since, the distribution of LoanAmount and Loan_Amount_Term is skewed. 
# we will impute median values

median(na.omit((complete_data$LoanAmount))) #126
median(na.omit((complete_data$Loan_Amount_Term))) #360

# And imputing the categorical variable with mode

Mode <- function(x, na.rm = FALSE) {
  if(na.rm){
    x = x[!is.na(x)]
  }
  
  ux <- unique(x)
  return(ux[which.max(tabulate(match(x, ux)))])
}

Mode(complete_data$Gender) #Male
Mode(complete_data$Married) #Yes
Mode(complete_data$Dependents) #0
Mode(complete_data$Self_Employed) #No
Mode(complete_data$Credit_History) #1

### df = data.frame(x = 1:20, y = c(1:10,rep(NA,10)))
### df$y[is.na(df$y)] = mean(df$y, na.rm=TRUE)

complete_data_mm <- complete_data
complete_data_mm$Gender[is.na(complete_data_mm$Gender)] <- 
  Mode(complete_data$Gender)
complete_data_mm$Married[is.na(complete_data_mm$Married)] <- 
  Mode(complete_data$Married)
complete_data_mm$Dependents[is.na(complete_data_mm$Dependents)] <- 
  Mode(complete_data$Dependents)
complete_data_mm$Self_Employed[is.na(complete_data_mm$Self_Employed)] <- 
  Mode(complete_data$Self_Employed)
complete_data_mm$Credit_History[is.na(complete_data_mm$Credit_History)] <- 
  Mode(complete_data$Credit_History)

complete_data_mm$LoanAmount[is.na(complete_data_mm$LoanAmount)] <- 
  median(na.omit((complete_data$LoanAmount)))
complete_data_mm$Loan_Amount_Term[is.na(complete_data_mm$
                                          Loan_Amount_Term)] <- 
  median(na.omit((complete_data$Loan_Amount_Term)))

# levels(complete_data_mm$Property_Area)
# as.numeric(complete_data_mm$
#              Property_Area)

complete_data_mm$Property_Area <- as.numeric(complete_data_mm$
                                               Property_Area)-2
complete_data_mm$Property_Area <- as.factor(complete_data_mm$
                                              Property_Area)

complete_data_mm$Dependents <- as.factor(ifelse(complete_data_mm$
                                                  Dependents == '0',0,1))

summary(complete_data_mm)

write.csv(complete_data_mm,file = "complete_data_mm.csv",row.names = F)

#data <- complete_data_mm







